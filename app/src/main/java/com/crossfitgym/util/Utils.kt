package com.crossfitgym.util

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

fun getTimeStamp(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val timestamp = Timestamp(System.currentTimeMillis())
    return sdf.format(timestamp)
}