package com.eningapps.hotelisto.di

import android.app.Application
import com.eningapps.hotelisto.MainActivity
import com.eningapps.hotelisto.di.modules.AppModule
import com.eningapps.hotelisto.di.modules.NetworkModule
import com.eningapps.hotelisto.di.modules.RepositoriesModule
import com.eningapps.hotelisto.di.modules.ViewModelsModule
import com.eningapps.hotelisto.fragments.FragmentOnboarding1
import com.eningapps.hotelisto.fragments.FragmentOnboarding2
import com.eningapps.hotelisto.fragments.FragmentOnboarding3
import com.eningapps.hotelisto.fragments.FragmentOnboarding4
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
    fun inject(onboardingFragment1: FragmentOnboarding1)
    fun inject(onboardingFragment2: FragmentOnboarding2)
    fun inject(onboardingFragment3: FragmentOnboarding3)
    fun inject(onboardingFragment4: FragmentOnboarding4)

    fun provideNavigatorHolder(): NavigatorHolder

}