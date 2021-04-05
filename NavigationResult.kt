package dev.lostfilm.client.ui.extension.navigation

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import dev.lostfilm.client.application.SharedViewModel

interface NavigationResult {

    fun getViewLifecycleOwner() : LifecycleOwner

    fun requireActivity() : FragmentActivity

    fun handleResult() {
        getSharedModel().getResultLiveData().observe(getViewLifecycleOwner(), { result ->
            result?.let {
                val received = onScreenResult(it.key, it.bundle)
                if(received) getSharedModel().clearResult()
            }
        })
    }

    fun setResult(key: String, bundle: Bundle) {
        getSharedModel().setResult(key, bundle)
    }

    fun onScreenResult(key: String, bundle: Bundle): Boolean {
        return false
    }

    fun getSharedModel() : SharedViewModel =
        ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    
}
