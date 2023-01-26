package jt.projects.jetpackcomposeexample.utils

import android.util.Log
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun String.ruFormat(): String {
    try {
        when (this.length) {
            16 -> {
                val currentFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
                val date = LocalDateTime.parse(this, currentFormat)
                val newFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
                return newFormat.format(date)
            }
            10 -> {
                val currentFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                val date = LocalDate.parse(this, currentFormat)
                val newFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                return newFormat.format(date)
            }
            else -> {}
        }
    } catch (e: Exception) {
        Log.d("TAG", e.message.toString())
    }
    return this
}