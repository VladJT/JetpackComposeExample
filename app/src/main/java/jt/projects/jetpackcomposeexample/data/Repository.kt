package jt.projects.jetpackcomposeexample.data

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import jt.projects.jetpackcomposeexample.BuildConfig
import org.json.JSONArray
import org.json.JSONObject

const val days = 5

fun getWeatherData(
    city: String,
    context: Context,
    daysList: MutableState<List<WeatherModel>>,
    currentDay: MutableState<WeatherModel>
) {
    val sb: StringBuilder = java.lang.StringBuilder().apply {
        append(BuildConfig.BASE_URL + "v1/forecast.json?")
        append("key=${BuildConfig.API_KEY}&")
        append("q=$city&")
        append("days=$days&")
        append("aqi=no&")
        append("alerts=no&")
        append("lang=en")
    }
    val url = sb.toString()

    val request = StringRequest(
        Request.Method.GET, url,
        { response ->
            val data = getWeatherByDays(response)
            daysList.value = data
            currentDay.value = data[0]
        }, { error ->
            error.message?.let { Log.d("TAG", it) }

        })

    val queue = Volley.newRequestQueue(context)
    queue.add(request)
}

fun getWeatherByDays(response: String): List<WeatherModel> {
    if (response.isBlank()) {
        return listOf()
    }
    val result = ArrayList<WeatherModel>()
    val mainObject = JSONObject(response)

    val days = mainObject.getJSONObject("forecast").getJSONArray("forecastday")
    for (i in 0 until days.length()) {
        val dayObject = days.getJSONObject(i)
        result.add(
            WeatherModel(
                city = mainObject.getJSONObject("location").getString("name"),
                time = dayObject.getString("date"),
                currentTemp = "",
                condition = dayObject.getJSONObject("day").getJSONObject("condition")
                    .getString("text"),
                icon = dayObject.getJSONObject("day").getJSONObject("condition").getString("icon"),
                maxTemp = dayObject.getJSONObject("day").getString("maxtemp_c") + "°C",
                minTemp = dayObject.getJSONObject("day").getString("mintemp_c") + "°C",
                hours = dayObject.getJSONArray("hour").toString()
            )
        )

    }

    // только для сегодняшнего дня
    result[0] = result[0].copy(
        time = mainObject.getJSONObject("current").getString("last_updated"),
        currentTemp = mainObject.getJSONObject("current").getString("temp_c") + "°C"
    )
    return result
}

fun getWeatherByHours(hours: String): List<WeatherModel> {
    if (hours.isEmpty()) return listOf()
    val hoursArray = JSONArray(hours)
    val result = ArrayList<WeatherModel>()

    for (i in 0 until hoursArray.length()) {
        val hourObject = hoursArray.getJSONObject(i)
        result.add(
            WeatherModel(
                time = hourObject.getString("time"),
                currentTemp = hourObject.getString("temp_c") + "°C",
                condition = hourObject.getJSONObject("condition").getString("text"),
                icon = hourObject.getJSONObject("condition").getString("icon"),
                maxTemp = "",
                minTemp = "",
                hours = ""
            )
        )
    }
    return result
}