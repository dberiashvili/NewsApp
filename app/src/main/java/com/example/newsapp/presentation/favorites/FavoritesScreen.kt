package com.example.newsapp.presentation.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentFavoritesScreenBinding


class FavoritesScreen : Fragment(R.layout.fragment_favorites_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        FragmentFavoritesScreenBinding.bind(view).onViewBind()
    }

    private fun FragmentFavoritesScreenBinding.onViewBind() {
        helloTV.text = "jaajh"

    }
}