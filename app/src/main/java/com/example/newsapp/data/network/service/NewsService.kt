package com.example.newsapp.data.network.service

import com.example.newsapp.data.network.utils.Utils
import com.example.newsapp.domain.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = Utils.API_KEY,
        @Query("page") page: Int = 1
    ): NewsResponse

    @GET("v2/everything")
    suspend fun getEveryArticle(
        @Query("apiKey") apiKey: String = Utils.API_KEY,
        @Query("q") query: String
    ): NewsResponse
}