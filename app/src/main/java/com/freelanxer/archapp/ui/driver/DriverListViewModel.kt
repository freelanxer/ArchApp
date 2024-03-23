package com.freelanxer.archapp.ui.driver

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.freelanxer.archapp.data.DataRepositoryResource
import com.freelanxer.archapp.data.Resource
import com.freelanxer.archapp.data.dto.Driver
import com.freelanxer.archapp.data.dto.DriverListModel
import com.freelanxer.archapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriverListViewModel @Inject constructor(
    private val dataRepository: DataRepositoryResource
): BaseViewModel() {

    private val driverListLiveDataPrivate = MutableLiveData<Resource<DriverListModel>>()
    val driverListLiveData: LiveData<Resource<DriverListModel>> get() = driverListLiveDataPrivate

    private val driverClickedLiveDataPrivate = MutableLiveData<Driver>()
    val driverClickedLiveData: LiveData<Driver> get() = driverClickedLiveDataPrivate

    fun getDriverList(sessionKey: Int? = null, driverNumber: Int? = null) {
        viewModelScope.launch {
            driverListLiveDataPrivate.value = Resource.Loading()
            dataRepository.requestDriver(sessionKey, driverNumber).collect {
                driverListLiveDataPrivate.value = it
            }
        }
    }

    fun onDriverClicked(driver: Driver) {
        driverClickedLiveDataPrivate.value = driver
    }

}