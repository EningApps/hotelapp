package com.eningapps.hotelisto.di

import android.app.Application
import com.eningapps.hotelisto.MainActivity
import com.eningapps.hotelisto.di.modules.NetworkModule
import com.eningapps.hotelisto.di.modules.RepositoriesModule
import com.eningapps.hotelisto.di.modules.ViewModelsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(NetworkModule::class, ViewModelsModule::class, RepositoriesModule::class))
@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)

}