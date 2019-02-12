package com.eningapps.hotelisto.navigation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.eningapps.hotelisto.fragments.*
import ru.terrakok.cicerone.android.SupportFragmentNavigator

class MainNavigator(fragmentManager: FragmentManager, containerId: Int) :
    SupportFragmentNavigator(fragmentManager, containerId) {

    override fun createFragment(screenKey: String?, data: Any?): Fragment? {
        return when (screenKey) {
            // Main
            Screens.ONBOARING1.name -> FragmentOnboarding1()
            Screens.ONBOARING2.name -> FragmentOnboarding2()
            Screens.ONBOARING3.name -> FragmentOnboarding3()
            Screens.ONBOARING4.name -> FragmentOnboarding4()
            Screens.MAIN.name -> FragmentMain()
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