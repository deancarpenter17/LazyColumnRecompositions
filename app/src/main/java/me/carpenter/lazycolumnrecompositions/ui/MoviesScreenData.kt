package me.carpenter.lazycolumnrecompositions.ui

import androidx.compose.runtime.Stable
import me.carpenter.lazycolumnrecompositions.data.Movie

data class MoviesScreenData(
    val pageTitle: String,
    val moviesList: List<Movie>
)