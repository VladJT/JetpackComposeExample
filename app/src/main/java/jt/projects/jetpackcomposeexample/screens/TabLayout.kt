package jt.projects.jetpackcomposeexample.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import jt.projects.jetpackcomposeexample.data.WeatherModel
import jt.projects.jetpackcomposeexample.data.getWeatherByHours
import jt.projects.jetpackcomposeexample.ui.theme.LightBlue
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun TabLayout(daysList: MutableState<List<WeatherModel>>, currentDay: MutableState<WeatherModel>) {
    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val selectedTabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {

        TabRow(selectedTabIndex = selectedTabIndex,
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
                Tab(selected = false, onClick = {
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
            val list = when (index) {
                0 -> getWeatherByHours(currentDay.value.hours)
                1 -> daysList.value
                else -> {
                    listOf<WeatherModel>()
                }
            }

            DaysList(list, currentDay)

        }//HorizontalPager

    } //Column
}


@Composable
fun DaysList(daysList: List<WeatherModel>, currentDay: MutableState<WeatherModel>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        itemsIndexed(
            daysList
        ) { index: Int, item: WeatherModel ->
            WeatherItem(item = item, currentDay)
        }
    }
}