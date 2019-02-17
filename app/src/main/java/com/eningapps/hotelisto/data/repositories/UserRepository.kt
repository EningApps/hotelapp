package com.eningapps.hotelisto.data.repositories

import io.reactivex.Observable

interface UserRepository {
    fun processLogin(login: String, password: String): Observable<Boolean>
}