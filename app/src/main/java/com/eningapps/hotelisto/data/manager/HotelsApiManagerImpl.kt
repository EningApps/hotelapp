package com.eningapps.hotelisto.data.manager

import com.eningapps.hotelisto.data.entities.internal.AppPhoto
import com.eningapps.hotelisto.data.network.services.HotelsApiService
import io.reactivex.Observable
import javax.inject.Inject


class HotelsApiManagerImpl @Inject constructor(
    private val hotelsApiService: HotelsApiService
) : HotelsApiManager {

    override fun getRecentPhotos(): Observable<List<AppPhoto>?> {
        return hotelsApiService
            .listRepos()
            .map {
                it.photos?.photo?.map { AppPhoto.fromFlickrPhoto(it) }
            }
            .doOnError {
                val x = it
            }
    }
}