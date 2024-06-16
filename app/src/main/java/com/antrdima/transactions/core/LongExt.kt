package com.antrdima.transactions.core

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.toFormattedTime(): String {
    val date = Date(this)
    val format = SimpleDateFormat("HH:mm", Locale.getDefault())
    return format.format(date)
}

fun Long.toFormattedDateTime(): String {
    val date = Date(this)
    val format = SimpleDateFormat("dd MMM HH:mm:ss", Locale.getDefault())
    return format.format(date)
}
