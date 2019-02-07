package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.data.repositories.HotelsRepository
import com.eningapps.hotelisto.navigation.AppRouter
import com.eningapps.hotelisto.navigation.Screens
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val hotelsRepository: HotelsRepository,
    private val router: AppRouter
) : ViewModel() {

    private val photosUrlsRelay = BehaviorSubject.create<List<String>>()

    val photosUrls: Observable<List<String>> = photosUrlsRelay


    fun onViewAttach() {
        router.navigateTo(Screens.ONBOARING.name)
    }


    fun getData() {
    }

}