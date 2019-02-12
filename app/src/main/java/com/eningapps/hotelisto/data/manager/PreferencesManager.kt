package com.eningapps.hotelisto.data.manager

import io.reactivex.Completable
import io.reactivex.Single

interface PreferencesManager {
    fun shouldShowOnboarding(): Single<Boolean>
    fun setShowOnboarding(shouldShow: Boolean): Completable
}