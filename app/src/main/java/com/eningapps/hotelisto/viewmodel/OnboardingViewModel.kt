package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.navigation.AppRouter
import com.eningapps.hotelisto.navigation.Screens
import java.util.*
import javax.inject.Inject

class OnboardingViewModel @Inject constructor(
    private val router: AppRouter
) : ViewModel() {

    private val interestsList: MutableList<String> = ArrayList()

    enum class OnboardingStep {
        STEP1, STEP2, STEP3
    }

    fun continueClicked(step: OnboardingStep) {
        when (step) {
            OnboardingStep.STEP1 -> {
                router.navigateTo(Screens.ONBOARING2.name)
            }
            OnboardingStep.STEP2 -> {
                router.navigateTo(Screens.ONBOARING3.name)
            }
            OnboardingStep.STEP3 -> {
                router.navigateTo(Screens.ONBOARING4.name)
            }
        }
    }

    fun addInterests(interests: List<String>) {
        interestsList.addAll(interests)
    }
}