package jt.projects.jetpackcomposeexample.examples

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import jt.projects.jetpackcomposeexample.BuildConfig
import org.json.JSONObject


//setContent {
//    weather("Murmansk", context = this)
//}


@Composable
fun weather(city: String, context: Context) {
    val state = remember {
        mutableStateOf("unknown")
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Temperature in $city = ${state.value} C", fontSize = 24.sp)
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.LightGray),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
                onClick = {
                    getTemperature(city, state, context)
                }) {
                Text(text = "Search", fontSize = 24.sp)
            }
        }
    }
}


private fun getTemperature(city: String, state: MutableState<String>, context: Context) {
    val url = BuildConfig.BASE_URL + "v1/current.json?" +
            "key=${BuildConfig.API_KEY}&" +
            "q=$city&" +
            "aqi=no"

    val queue = Volley.newRequestQueue(context)

    val request = StringRequest(
        Request.Method.GET, url,
        { response ->
            val jObj = JSONObject(response)
            state.value = jObj.getJSONObject("current").getString("temp_c")

        }, { error ->
            state.value = error.toString()

        })
    queue.add(request)
}