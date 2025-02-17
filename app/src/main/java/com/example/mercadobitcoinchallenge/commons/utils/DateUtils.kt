package com.example.mercadobitcoinchallenge.commons.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

private const val SLASH_SEPARATOR = "/"
const val DEFAULT_DATE_FORMAT_WITH_TIMEZONE_AND_MILLISECONDS =
    "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX"

object DateUtils {

    val localeBr = Locale("pt", "BR")

    fun formatDateBr(
        separator: String = SLASH_SEPARATOR,
        pattern: String = DEFAULT_DATE_FORMAT_WITH_TIMEZONE_AND_MILLISECONDS,
        locale: Locale = Locale.US,
        date: String,
        shortenYear: Boolean = false
    ): String {
        return try {
            val calendarDate = getCalendarFromDateString(
                pattern, locale, date
            )
            calendarDate?.let {
                formatDateBr(separator, calendarDate, shortenYear)
            }.orEmpty()
        } catch (ignore: ParseException) {
            ""
        }
    }

    private fun formatDateBr(
        separator: String,
        calendar: Calendar,
        shortenYear: Boolean = false,
        timeZone: TimeZone? = null
    ): String {
        return try {
            val date: Date = calendar.time
            val pattern =
                if (shortenYear) "dd${separator}MM${separator}yy" else "dd${separator}MM${separator}yyyy"
            val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
            timeZone?.let {
                dateFormat.timeZone = timeZone
            }
            return dateFormat.format(date)
        } catch (e: ParseException) {
            ""
        }
    }

    private fun getCalendarFromDateString(
        pattern: String,
        locale: Locale,
        inputDate: String
    ): Calendar? =
        runCatching {
            val formatter = SimpleDateFormat(pattern, locale)
            val date = formatter.parse(inputDate) as Date
            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar
        }.getOrNull()

}