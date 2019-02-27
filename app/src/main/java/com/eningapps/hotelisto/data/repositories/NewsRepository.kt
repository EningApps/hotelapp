package com.eningapps.hotelisto.data.repositories

import com.eningapps.hotelisto.data.entities.internal.News
import io.reactivex.Observable

interface NewsRepository {

    fun getNews(username: String): Observable<List<News>>

    fun reloadRecomended(): Observable<List<News>>
    fun reloadHot(): Observable<List<News>>
    fun reloadRecent(): Observable<List<News>>

}