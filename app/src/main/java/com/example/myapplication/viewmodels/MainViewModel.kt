package com.example.myapplication.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author Nav Singh
 */
class MainViewModel : ViewModel() {
    var job: Job? = null
    private val _updateNum: MutableLiveData<Int> = MutableLiveData()
    val updateNum: LiveData<Int> get() = _updateNum

    init {
        viewModelScope.launch {
            for (i in 0..1_00_000) {
                delay(3000)
                Log.e(TAG, "updatedTextNumeric:")
                _updateNum.value = i
            }
        }
    }

    fun doSomeHeavyWork() {
        job = viewModelScope.launch {
            for (i in 0..1_00_000) {
                delay(6000)
                Log.e(TAG, "doSomeHeavyWork: $i")
            }
        }
    }

    fun finishTheJob() {
        job?.cancel()
    }

    companion object {
        val TAG: String = MainViewModel::class.java.simpleName
    }
}
