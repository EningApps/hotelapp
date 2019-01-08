package com.eningapps.hotelisto.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface HotelsApiService {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<String>>

}