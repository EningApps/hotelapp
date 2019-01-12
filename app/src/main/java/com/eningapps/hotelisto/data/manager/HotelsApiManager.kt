package com.eningapps.hotelisto.data.manager

import com.eningapps.hotelisto.data.entities.internal.AppPhoto
import io.reactivex.Observable

interface HotelsApiManager {

    fun getRecentPhotos(): Observable<List<AppPhoto>?>

}