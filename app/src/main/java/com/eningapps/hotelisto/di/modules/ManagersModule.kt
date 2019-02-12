package com.eningapps.hotelisto.di.modules

import com.eningapps.hotelisto.data.manager.PreferencesManager
import com.eningapps.hotelisto.data.manager.PreferencesManagerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ManagersModule {

    @Singleton
    @Binds
    abstract fun providePrefsManager(impl: PreferencesManagerImpl): PreferencesManager

}

