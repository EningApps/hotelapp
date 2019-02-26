package com.eningapps.hotelisto.data.repositories

import com.eningapps.hotelisto.data.entities.internal.News
import com.eningapps.hotelisto.data.manager.NewsApiManager
import io.reactivex.Observable
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiManager: NewsApiManager
) : NewsRepository {

    override fun getNews(username: String): Observable<List<News>> = apiManager.getRecentNews(username)
}