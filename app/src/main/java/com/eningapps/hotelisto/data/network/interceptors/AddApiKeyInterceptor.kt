package com.eningapps.hotelisto.data.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response


class AddApiKeyInterceptor(
    private val apiKey: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url().newBuilder()
            .addQueryParameter("api_key", apiKey)
            .addQueryParameter("format", "json")
            .addQueryParameter("nojsoncallback", "1")
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}