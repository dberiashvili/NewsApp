package com.example.newsapp.data.repository

import com.example.newsapp.data.network.service.NewsService
import com.example.newsapp.domain.models.NewsResponse
import com.example.newsapp.domain.repository.NewsRepo
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(private val service: NewsService):NewsRepo {
    override suspend fun getTopHeadlines(): NewsResponse {
        return service.getTopHeadlines()
    }

    override suspend fun searchNews(query: String): NewsResponse {
        return service.getEveryArticle(query = query)
    }

}