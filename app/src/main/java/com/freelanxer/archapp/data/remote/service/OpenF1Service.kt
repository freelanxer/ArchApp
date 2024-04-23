package com.freelanxer.archapp.data.remote.service

import com.freelanxer.archapp.data.dto.Driver
import com.freelanxer.archapp.data.dto.Position
import com.freelanxer.archapp.data.dto.Session
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenF1Service {
    @GET("sessions")
    suspend fun getSession(@Query("year") year: Int? = null): Response<List<Session>>

    @GET("drivers")
    suspend fun getDriver(@Query("session_key") sessionKey: Int? = null,
                          @Query("driver_number") driverNumber: Int? = null
    ): Response<List<Driver>>

    @GET("position")
    suspend fun getPosition(@Query("session_key") sessionKey: Int? = null,
                            @Query("driver_number") driverNumber: Int? = null
    ): Response<List<Position>>
}