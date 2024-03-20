package com.freelanxer.archapp.ui.base

import android.content.res.Resources.NotFoundException
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun observeViewModel()

    protected abstract fun initViewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        observeViewModel()
    }

    protected fun showToast(text: Any) {
        when (text) {
            is String -> Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            is Int -> {
                val resString: String
                try {
                    resString = getString(text)
                } catch (_ : NotFoundException) {
                    return
                }
                Toast.makeText(this, resString, Toast.LENGTH_SHORT).show()
            }
        }
    }

}