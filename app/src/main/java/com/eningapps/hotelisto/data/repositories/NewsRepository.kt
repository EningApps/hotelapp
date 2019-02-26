package com.eningapps.hotelisto.data.repositories

import com.eningapps.hotelisto.data.entities.internal.News
import io.reactivex.Observable

interface NewsRepository {

    fun getNews(username: String): Observable<List<News>>

}