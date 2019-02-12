package com.eningapps.hotelisto.data.repositories

import io.reactivex.Completable
import io.reactivex.Single

interface SettingsRepository {
    fun shouldShowOnboarding(): Single<Boolean>
    fun setShowOnboarding(shouldShow: Boolean): Completable
}