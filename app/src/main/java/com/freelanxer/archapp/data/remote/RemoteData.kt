package com.freelanxer.archapp.data.remote

import com.freelanxer.archapp.data.Resource
import com.freelanxer.archapp.data.dto.Driver
import com.freelanxer.archapp.data.dto.DriverListModel
import com.freelanxer.archapp.data.dto.Position
import com.freelanxer.archapp.data.dto.PositionListModel
import com.freelanxer.archapp.data.dto.Session
import com.freelanxer.archapp.data.dto.SessionListModel
import com.freelanxer.archapp.data.error.NETWORK_ERROR
import com.freelanxer.archapp.data.remote.service.OpenF1Service
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(
    val serviceGenerator: ServiceGenerator,
): RemoteDataSource {

    override suspend fun requestSession(year: Int?): Resource<SessionListModel> {
        val f1Service = serviceGenerator.createService(OpenF1Service::class.java)
        return when(val response = processCall {f1Service.getSession(year)}) {
            is List<*> -> {
                Resource.Success(data = SessionListModel(response as ArrayList<Session>))
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    override suspend fun requestDriver(
        sessionKey: Int?,
        driverNumber: Int?
    ): Resource<DriverListModel> {
        val f1Service = serviceGenerator.createService(OpenF1Service::class.java)
        return when(val response = processCall { f1Service.getDriver(sessionKey, driverNumber) }) {
            is List<*> -> Resource.Success(data = DriverListModel(response as ArrayList<Driver>))
            else -> Resource.DataError(errorCode = response as Int)
        }
    }

    override suspend fun requestPosition(
        sessionKey: Int?,
        driverNumber: Int?
    ): Resource<PositionListModel> {
        val f1Service = serviceGenerator.createService(OpenF1Service::class.java)
        return  when(val response = processCall { f1Service.getPosition(sessionKey, driverNumber) }) {
            is List<*> -> Resource.Success(data = PositionListModel(response as ArrayList<Position>))
            else -> Resource.DataError(errorCode = response as Int)
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful)
                response.body()
            else
                responseCode
        } catch (ex: IOException) {
            NETWORK_ERROR
        }
    }

}