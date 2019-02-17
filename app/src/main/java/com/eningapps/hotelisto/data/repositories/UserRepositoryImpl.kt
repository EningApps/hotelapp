package com.eningapps.hotelisto.data.repositories

import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(

) : UserRepository {

    override fun processLogin(login: String, password: String): Observable<Boolean> {
        return Observable.timer(2000, TimeUnit.MILLISECONDS)
            .flatMap { Observable.just(true) }
    }
}