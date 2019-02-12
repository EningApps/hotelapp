package com.eningapps.hotelisto.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.eningapps.hotelisto.di.utils.ViewModelFactory
import com.eningapps.hotelisto.di.utils.ViewModelKey
import com.eningapps.hotelisto.viewmodel.MainViewModel
import com.eningapps.hotelisto.viewmodel.OnboardingViewModel
import com.eningapps.hotelisto.viewmodel.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Module
abstract class ViewModelsModule {

    @Singleton
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(OnboardingViewModel::class)
    internal abstract fun bindOnboardingViewModel(onboardingViewModel: OnboardingViewModel): ViewModel

}