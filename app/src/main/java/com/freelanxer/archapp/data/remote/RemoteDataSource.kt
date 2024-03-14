package com.freelanxer.archapp.data.remote

import com.freelanxer.archapp.data.Resource
import com.freelanxer.archapp.data.dto.SessionListModel

interface RemoteDataSource {
    suspend fun requestSession(): Resource<SessionListModel>
}