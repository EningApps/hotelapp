package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.navigation.AppRouter
import com.eningapps.hotelisto.navigation.Screens
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val router: AppRouter
) : ViewModel() {

    fun onViewAttach() {
        router.navigateTo(Screens.LOGIN.name)
    }

}