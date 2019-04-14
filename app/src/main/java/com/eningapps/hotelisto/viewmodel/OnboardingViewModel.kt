package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.data.repositories.SettingsRepository
import com.eningapps.hotelisto.navigation.AppRouter
import com.eningapps.hotelisto.navigation.Screens
import javax.inject.Inject

class OnboardingViewModel @Inject constructor(
    private val router: AppRouter,
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    enum class OnboardingStep {
        STEP1, STEP2, STEP3, STEP4
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
            OnboardingStep.STEP4 -> {
                settingsRepository
                    .setShowOnboarding(false)
                    .subscribe {
                        router.navigateTo(Screens.INIT_LOADING.name)
                    }
            }
        }
    }
}