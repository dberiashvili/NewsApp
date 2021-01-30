package com.example.newsapp.di

import com.example.newsapp.data.network.service.NewsService
import com.example.newsapp.data.network.utils.Utils
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)

object NetworkModule {
    @ExperimentalSerializationApi
    @Provides
    fun provideNetwork(): Retrofit = Retrofit.Builder()
        .baseUrl(Utils.BASE_URL)
        .addConverterFactory(Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }.asConverterFactory("application/json".toMediaType()))
        .client(provideHTTPClient())
        .build()


    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }

    @Provides
    fun provideHTTPClient() = OkHttpClient.Builder()
        .addInterceptor(provideInterceptor())
        .build()

    @Provides
    fun provideService(retrofit: Retrofit): NewsService = retrofit.create(NewsService::class.java)


}