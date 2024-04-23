package com.freelanxer.archapp.data.remote

import com.freelanxer.archapp.data.Resource
import com.freelanxer.archapp.data.dto.DriverListModel
import com.freelanxer.archapp.data.dto.PositionListModel
import com.freelanxer.archapp.data.dto.SessionListModel

interface RemoteDataSource {
    suspend fun requestSession(year: Int? = null): Resource<SessionListModel>

    suspend fun requestDriver(sessionKey: Int? = null, driverNumber: Int? = null): Resource<DriverListModel>

    suspend fun requestPosition(sessionKey: Int? = null, driverNumber: Int? = null): Resource<PositionListModel>
}