package com.tolerans.vitrinova.di

import com.tolerans.vitrinova.data.VitrinovaAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://www.vitrinova.com/api/v2/";

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideDiscoverAPI(okHttpClient: OkHttpClient): VitrinovaAPI =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
            .build()
            .create(VitrinovaAPI::class.java)


    @Singleton
    @Provides
    fun provideUserClient():OkHttpClient {
        // Debug mod okHttp logging
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpBuilder =
                OkHttpClient().newBuilder()
                        .addInterceptor(interceptor)

        return okHttpBuilder.build()

    }
}