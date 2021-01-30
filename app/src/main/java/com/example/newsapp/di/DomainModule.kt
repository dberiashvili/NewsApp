package com.example.newsapp.di

import com.example.newsapp.data.network.service.NewsService
import com.example.newsapp.data.repository.NewsRepoImpl
import com.example.newsapp.domain.repository.NewsRepo
import com.example.newsapp.domain.usecases.FetchNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun provideRepo(service: NewsService) = NewsRepoImpl(service)


    @Provides
    fun provideFetchNewsUseCase(repo:NewsRepo) = FetchNewsUseCase(repo)
}
