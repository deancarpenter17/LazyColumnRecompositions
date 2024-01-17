package me.carpenter.lazycolumnrecompositions.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import me.carpenter.lazycolumnrecompositions.data.Movie
import me.carpenter.lazycolumnrecompositions.data.ViewState
import me.carpenter.lazycolumnrecompositions.data.getMoviesList
import me.carpenter.lazycolumnrecompositions.ui.MoviesScreenData

class MoviesViewModel : ViewModel() {
    private val pageTitle = "Movies"

    val movies: StateFlow<ViewState<MoviesScreenData, Nothing>> = flow {
        var movies: List<Movie> = getMoviesList()
        // emit initial movies list with no ratings
        emit(
            ViewState.Loaded(
                MoviesScreenData(
                    pageTitle = pageTitle,
                    moviesList = movies
                )
            )
        )

        // every 2 seconds, update the rating of a single movie in the list.
        // the rest of the list items are identical
        var currentIndex = 0
        while (true) {
            delay(2000)
            movies = movies.update(
                currentIndex,
                movies[currentIndex].copy(
                    upvotes = movies[currentIndex].upvotes + 1
                )
            )

            emit(
                ViewState.Loaded(
                    MoviesScreenData(
                        pageTitle = pageTitle,
                        moviesList = movies
                    )
                )
            )
            currentIndex = if (currentIndex == movies.lastIndex - 1) 0 else currentIndex + 1
        }
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = ViewState.Loading
        )
}

fun <T> List<T>.update(index: Int, item: T): List<T> = toMutableList().apply { this[index] = item }
