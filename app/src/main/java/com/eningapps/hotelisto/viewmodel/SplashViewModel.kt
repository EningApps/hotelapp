package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.data.repositories.SettingsRepository
import com.eningapps.hotelisto.navigation.AppRouter
import com.eningapps.hotelisto.navigation.Screens
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val router: AppRouter,
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    fun onViewAttach() {
        settingsRepository
            .shouldShowOnboarding()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { navigateToOnboarding ->
                //                if (navigateToOnboarding) {
//                    router.navigateTo(Screens.ONBOARING1.name)
//                } else {
//                    router.navigateTo(Screens.MAIN.name)
//                }
                router.navigateTo(Screens.LOGIN.name)
            }
    }

}