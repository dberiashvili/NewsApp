package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.repository.NewsRepo
import javax.inject.Inject

class FetchNewsUseCase @Inject constructor(private val repo: NewsRepo) {
    suspend fun fetchNews() = repo.getTopHeadlines()
}