package com.ironmanyg.core.util

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * Returns the date of the timestamp in the format "YYYY-MM-DD".
 */
fun getDateNumFormat(timestamp: Long): String {
    val instant = Instant.fromEpochMilliseconds(timestamp)
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
    return "${localDateTime.year}-${
        localDateTime.monthNumber.toString().padStart(2, '0')
    }-${localDateTime.dayOfMonth.toString().padStart(2, '0')}"
}

/**
 * Returns the date of the timestamp in the format "YYYY MMM dd".
 */
fun getDateStringFormat(timestamp: Long): String {
    val instant = Instant.fromEpochMilliseconds(timestamp)
    val localDate = instant.toLocalDateTime(TimeZone.currentSystemDefault()).date
    return "${localDate.year} ${localDate.month.name} ${localDate.dayOfMonth}"
}

/**
 * Returns the time of the timestamp in the format "HH:mm:ss".
 */
fun getTime(timestamp: Long): String {
    val instant = Instant.fromEpochMilliseconds(timestamp)
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
    return "${localDateTime.hour.toString().padStart(2, '0')}:${
        localDateTime.minute.toString().padStart(2, '0')
    }:${localDateTime.second.toString().padStart(2, '0')}"
}