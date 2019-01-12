package com.eningapps.hotelisto.di.modules

import com.eningapps.hotelisto.data.repositories.HotelsRepository
import com.eningapps.hotelisto.data.repositories.HotelsRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun provideHotelsRepository(impl: HotelsRepositoryImpl): HotelsRepository

}