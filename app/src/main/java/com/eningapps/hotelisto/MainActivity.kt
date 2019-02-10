package com.eningapps.hotelisto

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.eningapps.hotelisto.adapter.PhotosAdapter
import com.eningapps.hotelisto.navigation.MainNavigator
import com.eningapps.hotelisto.viewmodel.MainViewModel
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    companion object {
        private val PHOTOS_GRID_COUNT = 3
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private lateinit var mainViewModel: MainViewModel

    private val rvAdapter = PhotosAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        val navigatorHolder = App.appComponent.provideNavigatorHolder()
        navigatorHolder.setNavigator(MainNavigator(supportFragmentManager, R.id.appContainer))
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.onViewAttach()
    }

    private val loadPhotos: (List<String>) -> Unit = { urls ->
        rvAdapter.updatePhotos(urls)
    }
}
