package com.example.newsapp.domain.repository

import com.example.newsapp.domain.models.NewsResponse

interface NewsRepo {
    suspend fun getTopHeadlines(): NewsResponse
    suspend fun searchNews(query:String):NewsResponse
}