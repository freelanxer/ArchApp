package com.freelanxer.archapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.freelanxer.archapp.data.dto.FeatureMenuItem
import com.freelanxer.archapp.ui.base.BaseViewModel

class HomeViewModel: BaseViewModel() {

    private val launchSessionPageLiveDataPrivate = MutableLiveData<FeatureMenuItem>()
    val launchSessionPage : LiveData<FeatureMenuItem> get() = launchSessionPageLiveDataPrivate

    fun launchSessionPage(menuItem: FeatureMenuItem) {
        launchSessionPageLiveDataPrivate.value = menuItem
    }
}