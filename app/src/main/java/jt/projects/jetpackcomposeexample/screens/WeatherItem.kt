package jt.projects.jetpackcomposeexample.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import jt.projects.jetpackcomposeexample.data.WeatherModel
import jt.projects.jetpackcomposeexample.ui.theme.LightBlue
import jt.projects.jetpackcomposeexample.utils.ruFormat

@Composable
fun WeatherItem(item: WeatherModel, currentDay: MutableState<WeatherModel>) {
    androidx.compose.material.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
            .clickable {
                if (item.hours.isNotBlank()) {
                    currentDay.value = item
                }
            },
        backgroundColor = LightBlue,
        elevation = 0.dp,
        shape = RoundedCornerShape(5.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.padding(start = 8.dp, top = 5.dp, bottom = 5.dp)) {
                Text(text = item.time.ruFormat())
                Text(
                    text = item.condition,
                    color = Color.White,
                    modifier = Modifier.widthIn(max = 100.dp)
                )
            }

            Text(
                text = item.currentTemp.ifEmpty {
                    "${item.maxTemp} / ${item.minTemp}"
                },
                color = Color.White,
                style = TextStyle(fontSize = 22.sp)
            )

            AsyncImage(
                modifier = Modifier
                    .size(40.dp),
                model = "https://${item.icon}",
                contentDescription = ""
            )
        }
    }
}