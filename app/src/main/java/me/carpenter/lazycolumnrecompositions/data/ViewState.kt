package me.carpenter.lazycolumnrecompositions.data

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

sealed class ViewState<out T, out E> {
    data class Loaded<T>(val data: T) : ViewState<T, Nothing>()

    data class Error<T, E>(val errorData: E) : ViewState<T, E>()

    data object Loading : ViewState<Nothing, Nothing>()
}

@Composable
fun <T, E> ViewStateScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    viewState: ViewState<T, E>,
    onLoading: @Composable () -> Unit = { DefaultLoadingScreen() },
    onError: @Composable (E) -> Unit = { DefaultErrorScreen() },
    onLoaded: @Composable (T) -> Unit
) {
    Box(modifier) {
        when (viewState) {
            is ViewState.Loading -> {
                onLoading()
            }

            is ViewState.Loaded -> {
                onLoaded(viewState.data)
            }

            is ViewState.Error -> {
                onError(viewState.errorData)
            }
        }
    }
}

@Composable
fun DefaultLoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Loading...",
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun DefaultErrorScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Something went wrong",
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

fun <T, E> ViewState<T, E>.toLoadedState(): T? = (this as? ViewState.Loaded<T>)?.data