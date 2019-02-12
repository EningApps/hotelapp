package com.eningapps.hotelisto.fragments

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eningapps.hotelisto.App
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.adapter.PhotosAdapter
import com.eningapps.hotelisto.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class FragmentMain : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel

    private lateinit var contentRvAdapter: PhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.appComponent.inject(this)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contentRvAdapter = PhotosAdapter(context!!)
        mainContentRecyclerView.adapter = contentRvAdapter
        mainContentRecyclerView.layoutManager = LinearLayoutManager(context!!)

        mainViewModel.photosUrls.subscribe {
            updateContent(it)
        }
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.onViewAttach()
    }

    private fun updateContent(urls: List<String>) {
        contentRvAdapter.updatePhotos(urls)
    }
}
