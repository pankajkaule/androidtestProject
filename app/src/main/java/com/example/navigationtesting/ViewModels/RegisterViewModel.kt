package com.example.navigationtesting.ViewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    val count = MutableLiveData<Int>(0)

    fun increamentCounter() {
        Log.d("Counter", "counter Increased..")
        count.value = count.value?.plus(1)
        Log.d("Counter", count.toString())
    }

    fun decreamentCounter() {
        count.value = count.value?.minus(1)
    }

    fun resetCounter() {
        count.value = 0
    }


}