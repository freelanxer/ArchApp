package com.freelanxer.archapp.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import com.freelanxer.archapp.R
import com.freelanxer.archapp.databinding.ActivityHomeBinding
import com.freelanxer.archapp.ui.base.BaseActivity
import com.freelanxer.archapp.ui.home.adapter.HomeMenuAdapter

class HomeActivity: BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private val menuList = listOf("Session", "Driver")
    private val menuAdapter: HomeMenuAdapter by lazy {
        HomeMenuAdapter(menuList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.menuListRv.setHasFixedSize(true)
        binding.menuListRv.adapter = menuAdapter
        binding.swiperRl.setOnRefreshListener {
            binding.swiperRl.isRefreshing = false
        }
    }

    override fun initViewBinding() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.headerView.titleTv.setText(R.string.app_name);
    }

    override fun observeViewModel() {

    }
}