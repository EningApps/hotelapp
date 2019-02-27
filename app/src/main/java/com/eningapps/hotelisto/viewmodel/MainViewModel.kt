package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.data.entities.internal.News
import com.eningapps.hotelisto.data.repositories.NewsRepository
import com.eningapps.hotelisto.navigation.AppRouter
import com.eningapps.hotelisto.navigation.Screens
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
    private val router: AppRouter
) : ViewModel() {

    private val newsSubject = BehaviorSubject.create<List<News>>()

    val photosUrls: Observable<List<News>> = newsSubject

    fun onViewAttach() {
        newsRepository
            .getNews("")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                newsSubject.onNext(it)
            }
    }

    fun moreCLicked(newsUrl: String) {
        router.navigateTo(Screens.NEWS_WEB_VIEW.name, newsUrl)
    }

    fun loadNews(titleMenu: String) {
        val get = when (titleMenu) {
            "Recomended" -> newsRepository.reloadRecomended()
            "Popular" -> newsRepository.reloadHot()
            else -> newsRepository.reloadRecent()
        }
        get.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                newsSubject.onNext(it)
            }
    }

}