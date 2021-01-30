package com.example.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.usecases.FetchNewsUseCase
import dagger.hilt.android.scopes.ViewModelScoped

class HomeViewModel @ViewModelScoped constructor(
    private val fetchNewsUseCase: FetchNewsUseCase
):ViewModel(){
    suspend fun fetchNews() = fetchNewsUseCase.fetchNews()
}