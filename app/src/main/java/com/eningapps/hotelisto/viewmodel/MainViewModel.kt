package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.data.repositories.HotelsRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val hotelsRepository: HotelsRepository
) : ViewModel() {

    private val photosUrlsRelay = BehaviorSubject.create<List<String>>()

    val photosUrls: Observable<List<String>> = photosUrlsRelay

    fun getData() {
        hotelsRepository
            .getRecentPhotos("")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                photosUrlsRelay.onNext(it!!.map { it.url })
            }
    }

}