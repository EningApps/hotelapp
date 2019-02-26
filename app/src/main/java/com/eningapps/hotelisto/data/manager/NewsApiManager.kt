package com.eningapps.hotelisto.data.manager

import com.eningapps.hotelisto.data.entities.internal.News
import io.reactivex.Observable

interface NewsApiManager {

    fun getRecentNews(username: String): Observable<List<News>>

}