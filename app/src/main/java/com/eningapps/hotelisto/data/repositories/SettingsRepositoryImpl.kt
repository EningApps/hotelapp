package com.eningapps.hotelisto.data.repositories

import com.eningapps.hotelisto.data.manager.PreferencesManager
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val preferencesManager: PreferencesManager
) : SettingsRepository {
    override fun shouldShowOnboarding(): Single<Boolean> = preferencesManager.shouldShowOnboarding()

    override fun setShowOnboarding(shouldShow: Boolean): Completable = preferencesManager.setShowOnboarding(shouldShow)

    override fun isLoggedIn(): Single<Boolean> = preferencesManager.isLoggedIn()

    override fun setLoggedIn(isLoggedIn: Boolean): Completable = preferencesManager.setLoggedIn(isLoggedIn)
}