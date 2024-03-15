package com.freelanxer.archapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.freelanxer.archapp.data.DataRepositoryResource
import com.freelanxer.archapp.data.Resource
import com.freelanxer.archapp.data.dto.SessionListModel
import com.freelanxer.archapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataRepository: DataRepositoryResource,
): BaseViewModel() {

    private val sessionListLiveDataPrivate = MutableLiveData<Resource<SessionListModel>>()
    val sessionListLiveData: LiveData<Resource<SessionListModel>> get() = sessionListLiveDataPrivate

    fun getSession(year: Int? = null) {
        viewModelScope.launch {
            sessionListLiveDataPrivate.value = Resource.Loading()
            dataRepository.requestSession(year).collect() {
                sessionListLiveDataPrivate.value = it
            }
        }
    }
}