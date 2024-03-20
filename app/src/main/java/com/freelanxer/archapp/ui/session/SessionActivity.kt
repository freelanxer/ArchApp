package com.freelanxer.archapp.ui.session

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.freelanxer.archapp.R
import com.freelanxer.archapp.TAG
import com.freelanxer.archapp.data.Resource
import com.freelanxer.archapp.data.dto.SessionListModel
import com.freelanxer.archapp.databinding.ActivitySessionBinding
import com.freelanxer.archapp.ui.base.BaseActivity
import com.freelanxer.archapp.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class SessionActivity: BaseActivity() {
    private val sdf = SimpleDateFormat("yyyy", Locale.getDefault())
    private val calendar: Calendar by lazy { Calendar.getInstance() }
    private lateinit var binding: ActivitySessionBinding
    private val sessionViewModel: SessionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getSessionList(sdf.format(calendar.time).toInt())
    }

    override fun initViewBinding() {
        binding = ActivitySessionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.headerView.titleTv.setText(R.string.feature_sessions);
    }

    private fun getSessionList(year: Int? = null) {
        sessionViewModel.getSessionList(year)
    }

    private fun onReceiveSessionList(status: Resource<SessionListModel>) {
        when(status) {
            is Resource.Loading -> Log.d(TAG, "onReceiveSessionList: $status")
            is Resource.DataError -> Log.d(TAG, "onReceiveSessionList: $status")
            is Resource.Success -> {
                status.data?.let {

                }
            }
        }
    }

    override fun observeViewModel() {
        observe(sessionViewModel.sessionListLiveData, ::onReceiveSessionList)
    }

}