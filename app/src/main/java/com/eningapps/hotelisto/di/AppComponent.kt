package com.eningapps.hotelisto.di

import android.app.Activity
import com.eningapps.hotelisto.di.modules.NetworkModule
import com.eningapps.hotelisto.di.modules.ViewModelsModule
import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(NetworkModule::class, ViewModelsModule::class))
@Singleton
interface AppComponent {

    fun inject(activity: Activity)

}