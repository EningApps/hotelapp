package com.eningapps.hotelisto.data.manager

import com.eningapps.hotelisto.data.entities.internal.News
import com.eningapps.hotelisto.data.entities.network.ResponseNews
import com.eningapps.hotelisto.data.network.services.NewsApiService
import io.reactivex.Observable
import javax.inject.Inject


class NewsApiManagerImpl @Inject constructor(
    private val newsApiService: NewsApiService
) : NewsApiManager {

    override fun getRecentNews(username: String): Observable<List<News>> {
        val newsStub =
            News(
                "https://cdn-images-1.medium.com/max/800/1*vpZ-2qPZvWXLKQX3NW77DQ.png",
                "Machine Learning with TensorFlow on Google Cloud Platform: code samples",
                "Over the past few months, my team has been working on creating two 5-course specializations on Coursera called “Machine Learning on Google Cloud Platform” and “Advanced Machine Learning on GCP”. The full 10-course journey will take you from a strategic overview of why ML matters all the way to building custom sequence models and recommendation engines.",
                "https://towardsdatascience.com/machine-learning-with-tensorflow-on-google-cloud-platform-code-samples-7c1bc07cd265"
            )
        val newsList = ArrayList<News>()
        for (i in 0..20)
            newsList.add(newsStub)
        return Observable.just(newsList)


//        return newsApiService
//            .getNews(username)
//            .map {
//                it.news.map { it.transform() }
//            }
//            .doOnError {
//                val x = it
//            }
    }


    private fun ResponseNews.transform(): News {
        return News(this.image_link.orEmpty(), this.name.orEmpty(), this.subtext.orEmpty(), this.link)
    }
}