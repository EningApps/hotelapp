package com.eningapps.hotelisto.viewmodel

import android.arch.lifecycle.ViewModel
import com.eningapps.hotelisto.data.repositories.SettingsRepository
import com.eningapps.hotelisto.data.repositories.UserRepository
import com.eningapps.hotelisto.navigation.AppRouter
import com.eningapps.hotelisto.navigation.Screens
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val router: AppRouter,
    private val settingsRepository: SettingsRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val loginStateSubject: BehaviorSubject<LoginState> = BehaviorSubject.create<LoginState>()

    enum class LoginState {
        VALID, ERROR, PROCESS
    }

    fun onViewAttach() {
        settingsRepository.isLoggedIn()
            .zipWith(settingsRepository.shouldShowOnboarding(),
                BiFunction { a: Boolean, b: Boolean ->
                    a to b
                })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { (isLogged, shouldShowOnboarding) ->
                if (isLogged && !shouldShowOnboarding) {
                    router.navigateTo(Screens.MAIN.name)
                } else if (isLogged && shouldShowOnboarding) {
                    router.navigateTo(Screens.ONBOARING1.name)
                }
            }
    }

    fun processLogin(login: String, password: String) {
        loginStateSubject.onNext(LoginState.PROCESS)
        userRepository
            .processLogin(login, password)
            .flatMap {
                if (it) {
                    settingsRepository.setLoggedIn(true)
                        .andThen(Observable.just(it))
                } else {
                    settingsRepository.setLoggedIn(false)
                        .andThen(Observable.just(it))
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { logged ->
                if (logged) {
                    router.navigateTo(Screens.ONBOARING1.name)
                    loginStateSubject.onNext(LoginState.VALID)
                } else {
                    loginStateSubject.onNext(LoginState.ERROR)
                }
            }
    }

    fun loginState(): Observable<LoginState> = loginStateSubject


}