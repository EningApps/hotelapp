package com.eningapps.hotelisto.di.modules

import com.eningapps.hotelisto.data.repositories.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun provideHotelsRepository(impl: HotelsRepositoryImpl): HotelsRepository

    @Singleton
    @Binds
    abstract fun provideSettingsRepository(impl: SettingsRepositoryImpl): SettingsRepository

    @Singleton
    @Binds
    abstract fun provideUserRepository(impl: UserRepositoryImpl): UserRepository

}