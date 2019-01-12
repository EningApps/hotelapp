package com.eningapps.hotelisto.data.repositories

import com.eningapps.hotelisto.data.entities.internal.AppPhoto
import io.reactivex.Observable

interface HotelsRepository {

    fun getRecentPhotos(city: String): Observable<List<AppPhoto>?>

}