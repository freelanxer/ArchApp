package com.freelanxer.archapp.data.dto

import com.squareup.moshi.Json

/**
 * F1 Session
 */
data class Session(
    @Json(name = "session_key")
    val sessionKey: Long,
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
    val meetingKey: Long,
    val location: String,
    @Json(name = "country_key")
    val countryKey: Long,
    @Json(name = "country_code")
    val countryCode: String,
    @Json(name = "country_name")
    val countryName: String,
    @Json(name = "circuit_key")
    val circuitKey: Long,
    @Json(name = "circuit_short_name")
    val circuitShortName: String,
    val year: Long,
)
