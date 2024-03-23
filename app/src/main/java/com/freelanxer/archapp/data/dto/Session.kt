package com.freelanxer.archapp.data.dto

import android.content.Context
import com.freelanxer.archapp.R
import com.squareup.moshi.Json
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * F1 Session
 */
data class Session(
    @Json(name = "session_key")
    val sessionKey: Int,
    @Json(name = "session_name")
    val sessionName: String,
    @Json(name = "date_start")
    val dateStart: String,
    @Json(name = "date_end")
    val dateEnd: String,
    @Json(name = "gmt_offset")
    val gmtOffset: String,
    @Json(name = "session_type")
    val sessionType: String,
    @Json(name = "meeting_key")
    val meetingKey: Int,
    val location: String,
    @Json(name = "country_key")
    val countryKey: Int,
    @Json(name = "country_code")
    val countryCode: String,
    @Json(name = "country_name")
    val countryName: String,
    @Json(name = "circuit_key")
    val circuitKey: Int,
    @Json(name = "circuit_short_name")
    val circuitShortName: String,
    val year: Int,
) {
    private val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    private val sdfDate = SimpleDateFormat("dd MMM", Locale.ENGLISH)
    private val sdfTime = SimpleDateFormat("HH:mm", Locale.ENGLISH)
    fun getSessionDate(): String {
        val date = sdf.parse(dateStart)
        return if (date == null) "" else sdfDate.format(date)
    }

    fun getSessionTime(): String {
        val date = sdf.parse(dateStart)
        return if (date == null) "" else sdfTime.format(date)
    }

    fun getCircuitName(context: Context): String {
        return String.format(context.getString(R.string.session_gp_param), circuitShortName)
    }
}

