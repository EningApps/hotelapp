package com.eningapps.hotelisto

import android.app.Application
import com.eningapps.hotelisto.di.AppComponent
import com.eningapps.hotelisto.di.DaggerAppComponent

class App : Application() {

    public companion object {
        public lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }
}