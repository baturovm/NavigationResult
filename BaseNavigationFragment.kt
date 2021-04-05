package dev.lostfilm.client.ui.extension.navigation

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dev.lostfilm.client.ui.fragments.base.BaseFragment

abstract class BaseNavigationFragment(layoutRes: Int) : BaseFragment(layoutRes),
    NavigationResult {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        handleResult()
    }

    override fun onScreenResult(key: String, bundle: Bundle): Boolean {
        if (key == "KEY") {
            //TODO
            return true
        }
        return super.onScreenResult(key, bundle)
    }

}
