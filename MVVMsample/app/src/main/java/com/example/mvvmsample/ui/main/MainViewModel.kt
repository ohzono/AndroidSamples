package com.example.mvvmsample.ui.main

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    val data = MutableLiveData<String>()
    private var _count = 0

    init {
        data.value = "Hello, Jetpack!"
    }

    fun onClick(view: View) {
        _count++
        data.value = "count: $_count"
    }
}
