package com.eningapps.hotelisto.data.manager

import com.eningapps.hotelisto.data.network.HotelsApiService
import javax.inject.Inject

class HotelsApiManagerImpl @Inject constructor(
    private val hotelsApiService: HotelsApiService
) : HotelsApiManager {

    override fun getHotelsByCity(city: String) {

    }

}