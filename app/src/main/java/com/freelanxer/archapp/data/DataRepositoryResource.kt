package com.freelanxer.archapp.data

import com.freelanxer.archapp.data.dto.SessionListModel
import kotlinx.coroutines.flow.Flow

interface DataRepositoryResource {
    suspend fun requestSession(): Flow<Resource<SessionListModel>>
}