package jt.projects.jetpackcomposeexample

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jt.projects.jetpackcomposeexample.examples.PersonItemRow
import jt.projects.jetpackcomposeexample.examples.getPersonTestData

/***
 * EXAMPLES
 */
@Composable
fun testList() {
    Column() {
        circleButton()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
            itemsIndexed(getPersonTestData()) { index, item ->
                PersonItemRow(item)
            }

        }

    }
}

@Composable
fun circleButton() {
    var counter = remember { mutableStateOf(0) }
    var color = remember { mutableStateOf(Color.Blue) }

    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color = color.value, shape = CircleShape)
            .clickable {
                counter.value++
                if (counter.value == 3) {
                    color.value = Color.Red
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = counter.value.toString(),
            style = TextStyle(color = Color.White, fontSize = 20.sp)
        )
    }

}


//@Preview(showBackground = true)
@Composable
fun showText(name: String) {
    Text(text = name, fontSize = 24f.sp)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listItem(name: String, profession: String) {
    var counter = remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                Log.d("MyLog", "clicked $name")
                counter.value++
            }
            .pointerInput(Unit) {
                detectDragGesturesAfterLongPress { change, dragAmount ->
                    Log.d("MyLog", "long pressed $dragAmount")
                }
            },
        shape = RoundedCornerShape(15.dp), elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.man),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    showText("$name, counter: [${counter.value}]")
                    showText(profession)
                }

            }
        }

    }
}