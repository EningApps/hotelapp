package com.eningapps.hotelisto

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.eningapps.hotelisto.fragments.FragmentLogin
import com.eningapps.hotelisto.fragments.FragmentMain
import com.eningapps.hotelisto.fragments.FragmentOnboarding1
import com.eningapps.hotelisto.navigation.MainNavigator
import com.eningapps.hotelisto.viewmodel.SplashViewModel
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    companion object {
        private val PHOTOS_GRID_COUNT = 3
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var splashViewModel: SplashViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
        splashViewModel = ViewModelProviders.of(this, viewModelFactory)[SplashViewModel::class.java]
        val navigatorHolder = App.appComponent.provideNavigatorHolder()
        navigatorHolder.setNavigator(MainNavigator(supportFragmentManager, R.id.appContainer))
    }

    override fun onStart() {
        super.onStart()
        splashViewModel.onViewAttach()
    }

    override fun onBackPressed() {
        val fragmentOnTop = supportFragmentManager.fragments.last()
        when (fragmentOnTop) {
            is FragmentLogin,
            is FragmentOnboarding1,
            is FragmentMain -> {
                finish()
            }
            else -> {
                super.onBackPressed()
            }
        }
    }
}
