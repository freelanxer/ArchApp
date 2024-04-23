package com.freelanxer.archapp.data.dto

import com.squareup.moshi.Json

/**
 * Driver position of racing
 */
data class Position(
    @Json(name = "session_key")
    val sessionKey: Int?,
    @Json(name = "meeting_key")
    val meetingKey: Int?,
    @Json(name = "driver_number")
    val driverNumber: Int?,
    @Json(name = "date")
    val date: String?,
    @Json(name = "position")
    val position: Int?,
)
