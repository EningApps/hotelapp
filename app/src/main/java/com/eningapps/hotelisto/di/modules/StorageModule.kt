package com.eningapps.hotelisto.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    companion object {
        const val PREFERENCES_NAME = "BanubaPreferences"
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

}

