package com.example.newsapp.presentation.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsBinding


class NewsFragment : Fragment(R.layout.fragment_news) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        FragmentNewsBinding.bind(view).onViewBind()
    }

    private fun FragmentNewsBinding.onViewBind() {

    }
}