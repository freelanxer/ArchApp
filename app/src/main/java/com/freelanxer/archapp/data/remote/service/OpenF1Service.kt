package com.freelanxer.archapp.data.remote.service

import com.freelanxer.archapp.data.dto.Session
import retrofit2.Response
import retrofit2.http.GET

interface OpenF1Service {
    @GET("sessions")
    suspend fun getSession(): Response<List<Session>>
}