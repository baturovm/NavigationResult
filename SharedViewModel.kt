package dev.lostfilm.client.navigation

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.lostfilm.client.ui.extension.navigation.NavResult

class SharedViewModel : ViewModel() {

    private val result: MutableLiveData<NavResult?> = MutableLiveData()

    fun setResult(key: String, bundle: Bundle) {
        result.value = NavResult(key, bundle)
    }

    fun clearResult() {
        result.value = null
    }

    fun getResultLiveData() : LiveData<NavResult?> {
        return result
    }

}
