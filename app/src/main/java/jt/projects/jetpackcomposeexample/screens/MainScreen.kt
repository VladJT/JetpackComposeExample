package jt.projects.jetpackcomposeexample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.accompanist.pager.*
import jt.projects.jetpackcomposeexample.R
import jt.projects.jetpackcomposeexample.ui.theme.LightBlue
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun MainCard() {
    Column(
        modifier = Modifier.padding(5.dp)

    ) {
        Card(
            //    elevation = CardDefaults.elevatedCardElevation(),
            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightBlue),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = "23.01.2023 12:20",
                        color = Color.White,
                        style = TextStyle(fontSize = 16.sp)
                    )
                    AsyncImage(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 8.dp),
                        model = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
                        contentDescription = ""
                    )
                }

                Text(
                    text = "Madrid", color = Color.White, style = TextStyle(fontSize = 24.sp)
                )

                Text(
                    text = "21° C", color = Color.White, style = TextStyle(fontSize = 64.sp)
                )

                Text(
                    text = "Sunny", color = Color.White, style = TextStyle(fontSize = 16.sp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // SEARCH
                    IconButton(onClick = {
                        /*TODO*/
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_search_24),
                            contentDescription = "",
                            tint = Color.White
                        )
                    }

                    Text(
                        text = "23 °C/12° C",
                        color = Color.White,
                        style = TextStyle(fontSize = 16.sp)
                    )

                    //SYNC
                    IconButton(onClick = {
                        /*TODO*/
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_cloud_sync_24),
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
            }//Column
        }

    }

}


@OptIn(ExperimentalPagerApi::class)
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun TabLayout() {
    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val selectedTabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {

        androidx.compose.material.TabRow(selectedTabIndex = selectedTabIndex,
            backgroundColor = LightBlue,
            contentColor = Color.White,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = Color.White,
                    modifier = Modifier.pagerTabIndicatorOffset(
                        pagerState,
                        tabPositions = tabPositions
                    )
                )
            }) {
            tabList.forEachIndexed { index, tabName ->
                androidx.compose.material.Tab(selected = false, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, modifier = Modifier.height(50.dp),
                    text = {
                        Text(
                            text = tabName,
                            style = TextStyle(
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    })
            }
        }//TabRow

        HorizontalPager(
            count = tabList.size, state = pagerState, modifier = Modifier.weight(1.0f)
        ) { index ->
            when (index) {
                0 -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top
                    ) {
                        items(15) { WeatherItem() }
                    }

                }
                1 -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top
                    ) {
                        items(2) { WeatherItem() }
                    }

                }
            }


        }//HorizontalPager


    } //Column
}