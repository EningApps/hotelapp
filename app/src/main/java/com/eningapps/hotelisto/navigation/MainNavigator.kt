package com.eningapps.hotelisto.navigation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.fragments.*
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import ru.terrakok.cicerone.commands.Command

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
            Screens.LOGIN.name -> FragmentLogin()
            else -> null
        }
    }

    override fun setupFragmentTransactionAnimation(
        command: Command?,
        currentFragment: Fragment?,
        nextFragment: Fragment?,
        fragmentTransaction: FragmentTransaction?
    ) {
        when (nextFragment) {
            is FragmentLogin,
            is FragmentMain -> {
                //do nothing
            }
            else -> {
                fragmentTransaction?.setCustomAnimations(R.anim.enter_slide_right, R.anim.exit_slide_left);
            }
        }
    }

    override fun exit() {
        // do nothing
    }

    override fun showSystemMessage(message: String?) {
        // TODO sneak bar
    }
}