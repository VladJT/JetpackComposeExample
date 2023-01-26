package jt.projects.jetpackcomposeexample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import jt.projects.jetpackcomposeexample.R
import jt.projects.jetpackcomposeexample.data.WeatherModel
import jt.projects.jetpackcomposeexample.ui.theme.LightBlue
import jt.projects.jetpackcomposeexample.utils.ruFormat


@Composable
fun MainCard(currentDay: MutableState<WeatherModel>) {

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
                        text = "${currentDay.value.time.ruFormat()}",
                        color = Color.White,
                        style = TextStyle(fontSize = 16.sp)
                    )
                    AsyncImage(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 8.dp),
                        model = "https:${currentDay.value.icon}",
                        contentDescription = ""
                    )
                }

                Text(
                    text = currentDay.value.city,
                    color = Color.White,
                    style = TextStyle(fontSize = 24.sp)
                )

                Text(
                    text = currentDay.value.currentTemp.ifEmpty { "${currentDay.value.maxTemp}/${currentDay.value.minTemp}" },
                    color = Color.White,
                    style = TextStyle(fontSize = 56.sp)
                )

                Text(
                    text = currentDay.value.condition,
                    color = Color.White,
                    style = TextStyle(fontSize = 16.sp)
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
                        text = "${currentDay.value.maxTemp} / ${currentDay.value.minTemp}",
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