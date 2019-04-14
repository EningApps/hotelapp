package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.data.repositories.SettingsRepository
import com.eningapps.hotelisto.navigation.AppRouter
import com.eningapps.hotelisto.navigation.Screens
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val router: AppRouter,
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    fun onViewAttach() {
        settingsRepository
            .shouldShowOnboarding()
            .subscribe { shouldShow ->
                router.navigateTo(Screens.ONBOARING1.name)
//
//                if (shouldShow) {
//                router.navigateTo(Screens.ONBOARING1.name)
//            } else {
//                router.navigateTo(Screens.MAIN.name)
//            }
            }
    }
}