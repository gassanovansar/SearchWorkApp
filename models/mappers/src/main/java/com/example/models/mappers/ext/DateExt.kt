package com.example.models.mappers.ext

import java.text.SimpleDateFormat

fun String.toDateDayMonth(): String {
    val fmt = SimpleDateFormat("yyyy-MM-dd")
    val date = fmt.parse(this)
    val fmtOut = SimpleDateFormat("dd MMMM")
    return fmtOut.format(date)

}