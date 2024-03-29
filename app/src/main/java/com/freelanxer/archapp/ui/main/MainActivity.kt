package com.freelanxer.archapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.freelanxer.archapp.TAG
import com.freelanxer.archapp.data.Resource
import com.freelanxer.archapp.data.dto.DriverListModel
import com.freelanxer.archapp.data.dto.SessionListModel
import com.freelanxer.archapp.databinding.ActivityMainBinding
import com.freelanxer.archapp.ui.base.BaseActivity
import com.freelanxer.archapp.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.getSession()
    }

    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun handleSessionList(status: Resource<SessionListModel>) {
        when(status) {
            is Resource.Loading -> Log.d(TAG, "handleSessionList: $status")
            is Resource.DataError -> Log.e(TAG, "handleSessionList: $status")
            is Resource.Success -> {
                val model = status.data
                model?.let {
                    for(session in it.sessionList) {
                        Log.d(TAG, "handleSessionList: ${session.countryName}")
                    }
                }
            }

        }
    }

    private fun handleDriverList(status: Resource<DriverListModel>) {
        when(status) {
            is Resource.Loading -> Log.d(TAG, "handleDriverList: $status")
            is Resource.DataError -> Log.d(TAG, "handleDriverList: $status")
            is Resource.Success -> {
                status.data?.let {
                    for (driver in it.driverList) {
                        Log.d(TAG, "handleDriverList: ${driver.fullName}")
                    }
                }
            }
        }
    }

    override fun observeViewModel() {
        observe(mainViewModel.sessionListLiveData, ::handleSessionList)
        observe(mainViewModel.driverListLiveData, ::handleDriverList)
    }

}