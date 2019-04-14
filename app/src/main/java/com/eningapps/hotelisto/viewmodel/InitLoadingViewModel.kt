package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.navigation.AppRouter
import com.eningapps.hotelisto.navigation.Screens
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class InitLoadingViewModel @Inject constructor(
    private val router: AppRouter
) : ViewModel() {

    private val stateRelay = BehaviorSubject.create<LoadingState>()

    val observeLoadingState: Observable<LoadingState> = stateRelay

    enum class LoadingState {
        INIT, LOADING, COMPLETE
    }

    fun onViewStart() {
        stateRelay.onNext(LoadingState.INIT)
        Observable.timer(1500, TimeUnit.MILLISECONDS)
            .doOnNext {
                stateRelay.onNext(LoadingState.LOADING)
            }
            .flatMap {
                Observable.timer(2500, TimeUnit.MILLISECONDS)
            }
            .doOnNext {
                stateRelay.onNext(LoadingState.COMPLETE)
            }
            .flatMap {
                Observable.timer(2, TimeUnit.SECONDS)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                router.navigateTo(Screens.MAIN.name)
            }
    }

}