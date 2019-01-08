package com.eningapps.hotelisto.di.modules

import android.arch.lifecycle.ViewModelProvider
import com.eningapps.hotelisto.di.utils.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelsModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}