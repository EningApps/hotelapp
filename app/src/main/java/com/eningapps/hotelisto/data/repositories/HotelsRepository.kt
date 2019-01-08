package com.eningapps.hotelisto.data.repositories

interface HotelsRepository {

    fun getHotelsByCity(city: String)

}