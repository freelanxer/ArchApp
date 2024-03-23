package com.freelanxer.archapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.freelanxer.archapp.R
import com.freelanxer.archapp.data.dto.FeatureMenuItem
import com.freelanxer.archapp.databinding.ActivityHomeBinding
import com.freelanxer.archapp.ui.base.BaseActivity
import com.freelanxer.archapp.ui.home.adapter.HomeMenuAdapter
import com.freelanxer.archapp.ui.session.SessionActivity
import com.freelanxer.archapp.utils.observe

class HomeActivity: BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private val menuList = listOf(
        FeatureMenuItem(0, "Session") ,
        FeatureMenuItem(1, "Driver"),
    )
    private val menuAdapter: HomeMenuAdapter by lazy {
        HomeMenuAdapter(menuList, homeViewModel)
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
        binding.headerView.titleTv.visibility = View.GONE
    }

    override fun observeViewModel() {
        observe(homeViewModel.launchSessionPage, ::launchSessionPage)
    }

    private fun launchSessionPage(menuItem: FeatureMenuItem) {
        when(menuItem.id) {
            0 -> {
                val intent = Intent(this, SessionActivity::class.java)
                startActivity(intent)
            }
        }
    }

}