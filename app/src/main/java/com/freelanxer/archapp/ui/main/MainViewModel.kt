package com.freelanxer.archapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.freelanxer.archapp.data.DataRepositoryResource
import com.freelanxer.archapp.data.Resource
import com.freelanxer.archapp.data.dto.SessionListModel
import com.freelanxer.archapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel constructor(
    private val dataRepository: DataRepositoryResource,
): BaseViewModel() {

    val sessionListLiveDataPrivate = MutableLiveData<Resource<SessionListModel>>()
    val sessionListLiveData: LiveData<Resource<SessionListModel>> get() = sessionListLiveDataPrivate

    fun getSession() {
        viewModelScope.launch {
            sessionListLiveDataPrivate.value = Resource.Loading()
            dataRepository.requestSession().collect() {
                sessionListLiveDataPrivate.value = it
            }
        }
    }
}