package com.eningapps.hotelisto.data.repositories

import com.eningapps.hotelisto.data.entities.internal.AppPhoto
import com.eningapps.hotelisto.data.manager.HotelsApiManager
import io.reactivex.Observable
import javax.inject.Inject

class HotelsRepositoryImpl @Inject constructor(
    private val apiManager: HotelsApiManager
) : HotelsRepository {

    override fun getRecentPhotos(city: String): Observable<List<AppPhoto>?> = apiManager.getRecentPhotos()
}