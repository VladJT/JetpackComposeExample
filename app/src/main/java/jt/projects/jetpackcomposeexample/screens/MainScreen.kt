package jt.projects.jetpackcomposeexample.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import jt.projects.jetpackcomposeexample.R
import jt.projects.jetpackcomposeexample.ui.theme.BlueLight


@Preview(showBackground = true)
@Composable
fun MainScreen() {
    Image(
        painter = painterResource(id = R.drawable.bg2),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.5f),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)

    ) {
        Card(
            //    elevation = CardDefaults.elevatedCardElevation(),
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BlueLight),
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
                    text = "Madrid",
                    color = Color.White,
                    style = TextStyle(fontSize = 24.sp)
                )

                Text(
                    text = "21° C",
                    color = Color.White,
                    style = TextStyle(fontSize = 64.sp)
                )

                Text(
                    text = "Sunny",
                    color = Color.White,
                    style = TextStyle(fontSize = 16.sp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        /*TODO*/
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_search_24),
                            contentDescription = "", tint = Color.White
                        )
                    }

                    Text(
                        text = "23 °C/12° C",
                        color = Color.White,
                        style = TextStyle(fontSize = 16.sp)
                    )

                    IconButton(onClick = {
                        /*TODO*/
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_cloud_sync_24),
                            contentDescription = "", tint = Color.White
                        )
                    }
                }
            }//Column
        }

    }

}