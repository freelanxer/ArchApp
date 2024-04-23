package com.freelanxer.archapp.data

import com.freelanxer.archapp.data.dto.DriverListModel
import com.freelanxer.archapp.data.dto.PositionListModel
import com.freelanxer.archapp.data.dto.SessionListModel
import kotlinx.coroutines.flow.Flow

interface DataRepositoryResource {
    suspend fun requestSession(year: Int? = null): Flow<Resource<SessionListModel>>

    suspend fun requestDriver(sessionKey: Int? = null, driverNumber: Int? = null): Flow<Resource<DriverListModel>>

    suspend fun requestPosition(sessionKey: Int? = null, driverNumber: Int? = null): Flow<Resource<PositionListModel>>
}