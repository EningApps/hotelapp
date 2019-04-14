package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.navigation.AppRouter
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: AppRouter
) : ViewModel() {


    fun onViewAttach() {

    }

}