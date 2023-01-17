package jt.projects.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import jt.projects.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .background(Color.Red)
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    showText("Hello")
                    showText("JC")
                    showText("Android")
                }

                Column(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    showText("111")
                    showText("222")
                    showText("333")
                }
            }


        }
    }


}

//@Preview(showBackground = true)
@OptIn(ExperimentalUnitApi::class)
@Composable
fun showText(name: String) {
    Text(text = name, fontSize = TextUnit(24f, TextUnitType.Sp))
}