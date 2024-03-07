package com.freelanxer.archapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.freelanxer.archapp.R
import com.freelanxer.archapp.databinding.ActivityMainBinding
import com.freelanxer.archapp.ui.base.BaseActivity

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun observeViewModel() {

    }
}