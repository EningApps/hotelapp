package com.eningapps.hotelisto.di

import android.app.Application
import com.eningapps.hotelisto.MainActivity
import com.eningapps.hotelisto.di.modules.AppModule
import com.eningapps.hotelisto.di.modules.NetworkModule
import com.eningapps.hotelisto.di.modules.RepositoriesModule
import com.eningapps.hotelisto.di.modules.ViewModelsModule
import dagger.BindsInstance
import dagger.Component
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Singleton


@Component(
    modules = arrayOf(
        NetworkModule::class,
        ViewModelsModule::class,
        RepositoriesModule::class,
        AppModule::class
    )
)
@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)

    fun provideNavigatorHolder(): NavigatorHolder

}