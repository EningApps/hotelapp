package com.eningapps.hotelisto.data.network.services

import com.eningapps.hotelisto.data.entities.network.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface NewsApiService {

    @GET("/username/{username}")
    fun getNews(username: String): Observable<NewsResponse>

}