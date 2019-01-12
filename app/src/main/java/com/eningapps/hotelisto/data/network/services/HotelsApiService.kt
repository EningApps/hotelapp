package com.eningapps.hotelisto.data.network.services

import com.eningapps.hotelisto.data.entities.network.FlickrResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface HotelsApiService {

    @GET("?method=flickr.photos.getRecent")
    fun listRepos(): Observable<FlickrResponse>

}