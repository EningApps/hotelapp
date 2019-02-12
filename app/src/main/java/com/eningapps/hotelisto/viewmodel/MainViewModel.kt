package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.data.repositories.HotelsRepository
import com.eningapps.hotelisto.navigation.AppRouter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val hotelsRepository: HotelsRepository,
    private val router: AppRouter
) : ViewModel() {

    private val photosUrlsSubject = BehaviorSubject.create<List<String>>()

    val photosUrls: Observable<List<String>> = photosUrlsSubject

    fun onViewAttach() {
        hotelsRepository
            .getRecentPhotos("")
            .map {
                it.map { it.url }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                photosUrlsSubject.onNext(it)
            }
    }

}