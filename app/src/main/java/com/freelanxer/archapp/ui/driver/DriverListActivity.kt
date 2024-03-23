package com.freelanxer.archapp.ui.driver

import android.os.Bundle
import com.freelanxer.archapp.databinding.ActivityDriverListBinding
import com.freelanxer.archapp.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DriverListActivity: BaseActivity() {
    companion object {
        const val EXTRA_SESSION_KEY = "EXTRA_SESSION_KEY"
    }

    private lateinit var binding: ActivityDriverListBinding
    private val sessionKey: Int by lazy { intent.getIntExtra(EXTRA_SESSION_KEY, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initViewBinding() {
        binding = ActivityDriverListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun observeViewModel() {

    }

}