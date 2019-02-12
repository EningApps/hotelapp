package com.eningapps.hotelisto.di.modules

import android.app.Application
import android.content.Context
import com.eningapps.hotelisto.navigation.AppRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun provideAppRouter(): AppRouter = AppRouter()

    @Singleton
    @Provides
    fun provideNavigatorHolder(appRouter: AppRouter): NavigatorHolder = Cicerone.create(appRouter).navigatorHolder

}