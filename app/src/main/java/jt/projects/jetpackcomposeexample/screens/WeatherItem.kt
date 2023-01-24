package jt.projects.jetpackcomposeexample.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import jt.projects.jetpackcomposeexample.ui.theme.LightBlue

@Preview(showBackground = true)
@Composable
fun WeatherItem() {
    androidx.compose.material.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp),
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
                Text(text = "12:00")
                Text(text = "Sunny", color = Color.White)
            }

            Text(
                text = "23 °C",
                color = Color.White,
                style = TextStyle(fontSize = 26.sp)
            )

            AsyncImage(
                modifier = Modifier
                    .size(40.dp),
                model = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
                contentDescription = ""
            )
        }
    }
}