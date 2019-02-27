package com.eningapps.hotelisto.data.repositories

import com.eningapps.hotelisto.data.entities.internal.News
import com.eningapps.hotelisto.data.manager.NewsApiManager
import io.reactivex.Observable
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiManager: NewsApiManager
) : NewsRepository {

    override fun getNews(username: String): Observable<List<News>> = apiManager.getRecentNews(username)

    override fun reloadRecomended(): Observable<List<News>> {
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
    }

    override fun reloadHot(): Observable<List<News>> {
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
    }

    override fun reloadRecent(): Observable<List<News>> {
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
    }
}