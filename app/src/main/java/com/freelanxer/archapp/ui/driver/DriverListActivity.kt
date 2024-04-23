package com.freelanxer.archapp.ui.driver

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.freelanxer.archapp.R
import com.freelanxer.archapp.TAG
import com.freelanxer.archapp.data.Resource
import com.freelanxer.archapp.data.dto.Driver
import com.freelanxer.archapp.data.dto.DriverListModel
import com.freelanxer.archapp.data.dto.PositionListModel
import com.freelanxer.archapp.databinding.ActivityDriverListBinding
import com.freelanxer.archapp.ui.base.BaseActivity
import com.freelanxer.archapp.ui.driver.adapter.DriverListAdapter
import com.freelanxer.archapp.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DriverListActivity: BaseActivity() {
    companion object {
        const val EXTRA_SESSION_KEY = "EXTRA_SESSION_KEY"
    }

    private lateinit var binding: ActivityDriverListBinding
    private val driverListViewModel: DriverListViewModel by viewModels()
    private val sessionKey: Int by lazy { intent.getIntExtra(EXTRA_SESSION_KEY, 0) }
    private val driverAdapter: DriverListAdapter by lazy {
        DriverListAdapter(null, driverListViewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.driverListRv.setHasFixedSize(true)
        binding.driverListRv.layoutManager = LinearLayoutManager(this)
        binding.driverListRv.adapter = driverAdapter

        binding.swiperRl.setOnRefreshListener {
            binding.swiperRl.isRefreshing = false
            driverListViewModel.getDriverList(sessionKey)
        }

        driverListViewModel.getDriverList(sessionKey)

    }

    override fun initViewBinding() {
        binding = ActivityDriverListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.headerView.titleTv.text = getString(R.string.feature_drivers)
    }

    private fun handleDriverList(status: Resource<DriverListModel>) {
        when (status) {
            is Resource.Loading -> Log.d(TAG, "handleDriverList: $status")
            is Resource.DataError -> Log.d(TAG, "handleDriverList: $status")
            is Resource.Success -> {
                driverListViewModel.getPositionList(sessionKey)
            }
        }
    }

    private fun onDriverClicked(driver: Driver) {

    }

    private fun handlePositionList(status: Resource<PositionListModel>) {
        when (status) {
            is Resource.Loading -> Log.d(TAG, "handlePositionList: $status")
            is Resource.DataError -> Log.d(TAG, "handlePositionList: $status")
            is Resource.Success -> {
                val sortedList = mutableListOf<Driver>()
                val map = mutableMapOf<Int, Int>()
                status.data?.positionList?.forEach { positionItem ->
                    if (positionItem.position != null && positionItem.driverNumber != null) {
                        map[positionItem.position] = positionItem.driverNumber
                    }
                }
                map.toSortedMap().toList().forEach { driverNumber ->
                    driverListViewModel.driverList?.find { it.driverNumber ==  driverNumber.second}?.let {
                        sortedList.add(it)
                    }
                }.also {
                    driverAdapter.setData(sortedList)
                }
            }
        }
    }

    override fun observeViewModel() {
        observe(driverListViewModel.driverListLiveData, ::handleDriverList)
        observe(driverListViewModel.driverClickedLiveData, ::onDriverClicked)
        observe(driverListViewModel.positionListLiveData, ::handlePositionList)
    }

}