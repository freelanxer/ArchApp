package com.freelanxer.archapp.data

import com.freelanxer.archapp.data.dto.SessionListModel
import com.freelanxer.archapp.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(
    val remoteRepository: RemoteData,
    val ioDispatcher: CoroutineContext,
): DataRepositoryResource {

    override suspend fun requestSession(year: Int?): Flow<Resource<SessionListModel>> {
        return flow {
            emit(remoteRepository.requestSession(year))
        }.flowOn(ioDispatcher)
    }

}