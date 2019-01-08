package com.eningapps.hotelisto.di.modules

import com.eningapps.hotelisto.BuildConfig
import com.eningapps.hotelisto.data.network.HotelsApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
abstract class NetworkModule {

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
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideApiService(okHttpClient: OkHttpClient): HotelsApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.HOTELS_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HotelsApiService::class.java)
    }

}