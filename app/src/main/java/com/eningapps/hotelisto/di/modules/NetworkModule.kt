package com.eningapps.hotelisto.di.modules

import com.eningapps.hotelisto.BuildConfig
import com.eningapps.hotelisto.data.manager.NewsApiManager
import com.eningapps.hotelisto.data.manager.NewsApiManagerImpl
import com.eningapps.hotelisto.data.network.interceptors.AddApiKeyInterceptor
import com.eningapps.hotelisto.data.network.services.NewsApiService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    companion object {
        const val NETWORK_TIMEOUT = 60 * 1000L
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
        builder.readTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
        builder.writeTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)
        }
        builder.addInterceptor(AddApiKeyInterceptor(BuildConfig.FLICKR_API_KEY))
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideApiService(okHttpClient: OkHttpClient): NewsApiService {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.FLICKR_API_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(NewsApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideApiManager(impl: NewsApiManagerImpl): NewsApiManager = impl

}