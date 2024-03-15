package com.freelanxer.archapp.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * F1 Driver
 */
data class Driver(
    @Json(name = "broadcast_name")
    val broadcastName: String?,
    @Json(name = "country_code")
    val countryCode: String?,
    @Json(name = "driver_number")
    val driverNumber: Int?,
    @Json(name = "first_name")
    val firstName: String?,
    @Json(name = "full_name")
    val fullName: String?,
    @Json(name = "headshot_url")
    val headshotUrl: String?,
    @Json(name = "last_name")
    val lastName: String?,
    @Json(name = "meeting_key")
    val meetingKey: Int?,
    @Json(name = "name_acronym")
    val nameAcronym: String?,
    @Json(name = "session_key")
    val sessionKey: Int?,
    @Json(name = "team_colour")
    val teamColour: String?,
    @Json(name = "team_name")
    val teamName: String?
)