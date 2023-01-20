package jt.projects.jetpackcomposeexample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
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
import androidx.compose.ui.unit.*
import jt.projects.jetpackcomposeexample.data.PersonItemRow
import jt.projects.jetpackcomposeexample.data.getPersonTestData
import jt.projects.jetpackcomposeexample.ui.theme.Gray100


class MainActivity : ComponentActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                circleItem()

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                ) {
                    itemsIndexed(getPersonTestData()) { _, item ->
                        PersonItemRow(item)
                    }

                }

            }
        }
    }


}

@Composable
private fun circleItem() {
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

