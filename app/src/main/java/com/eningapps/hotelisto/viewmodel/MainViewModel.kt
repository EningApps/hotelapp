package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.data.repositories.HotelsRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val hotelsRepository: HotelsRepository
) : ViewModel() {


}