package com.example.newsapp.presentation.home

import android.os.Bundle
import android.util.Log.d
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentHomeScreenBinding
import com.example.newsapp.presentation.adapters.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.fragment_home_screen) {
    lateinit var adapter: NewsAdapter
    private val viewModel: HomeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        FragmentHomeScreenBinding.bind(view).onViewBind()
        setHasOptionsMenu(true)
    }


    private fun FragmentHomeScreenBinding.onViewBind() {
        adapter = NewsAdapter()
        viewModel.viewModelScope.launch {
            viewModel.fetchNews().articles.map {
                d("articleTitle", it.title)
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val search = menu.findItem(R.id.search_menu)
        if (search !== null) {
            val searchView = search.actionView as SearchView
            searchView.queryHint = "Search for the news"
        }
    }
}