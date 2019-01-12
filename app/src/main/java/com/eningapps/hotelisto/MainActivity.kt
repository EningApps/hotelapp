package com.eningapps.hotelisto

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.eningapps.hotelisto.adapter.PhotosAdapter
import com.eningapps.hotelisto.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]

        getDataBtn.setOnClickListener { mainViewModel.getData() }

        mainViewModel
            .photosUrls
            .subscribe(loadPhotos)


    }

    private val loadPhotos: (List<String>) -> Unit = { urls ->
        photosRecyclerView.layoutManager = LinearLayoutManager(this)
        photosRecyclerView.adapter = PhotosAdapter(urls, this)
    }
}
