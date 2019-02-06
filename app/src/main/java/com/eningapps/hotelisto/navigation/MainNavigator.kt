package com.eningapps.hotelisto.navigation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.eningapps.hotelisto.fragments.FragmentOnboarding1
import ru.terrakok.cicerone.android.SupportFragmentNavigator

class MainNavigator(fragmentManager: FragmentManager, containerId: Int) :
    SupportFragmentNavigator(fragmentManager, containerId) {

    override fun createFragment(screenKey: String?, data: Any?): Fragment? {
        return when (screenKey) {
            // Main
            Screens.ONBOARING.name -> FragmentOnboarding1()
            else -> null
        }
    }

    override fun exit() {
        // do nothing
    }

    override fun showSystemMessage(message: String?) {
        // TODO sneak bar
    }
}