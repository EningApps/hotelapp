package com.eningapps.hotelisto.data.manager

import android.content.SharedPreferences
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject


class PreferencesManagerImpl @Inject constructor(
    private val preferences: SharedPreferences
) : PreferencesManager {

    companion object {
        const val KEY_SHOW_ONBOARDING = "KEY_GDPR_OPTOUT"
        const val KEY_IS_LOGGED = "KEY_IS_LOGGED"
    }

    override fun shouldShowOnboarding(): Single<Boolean> = Single.fromCallable {
        preferences.getBoolean(KEY_SHOW_ONBOARDING, true)
    }

    override fun setShowOnboarding(shouldShow: Boolean): Completable = Completable.fromAction {
        preferences.edit().putBoolean(KEY_SHOW_ONBOARDING, shouldShow).apply()
    }

    override fun isLoggedIn(): Single<Boolean> = Single.fromCallable {
        preferences.getBoolean(KEY_IS_LOGGED, false)
    }


    override fun setLoggedIn(isLoggedIn: Boolean): Completable = Completable.fromAction {
        preferences.edit().putBoolean(KEY_IS_LOGGED, isLoggedIn).apply()
    }
}
