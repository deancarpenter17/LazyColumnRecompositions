package me.carpenter.lazycolumnrecompositions.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import me.carpenter.lazycolumnrecompositions.data.Movie
import me.carpenter.lazycolumnrecompositions.vm.MoviesViewModel

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel
) {
    // collect ui state
    val movies = viewModel.movies.collectAsStateWithLifecycle().value
    // TODO: call toolbar composable
    // call list composable
    MoviesList(
        movies = movies,
        modifier = Modifier.padding(16.dp)
    )

}

@Composable
fun MoviesList(
    movies: List<Movie>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        movies.forEachIndexed { index, movie ->
            item {
                MovieRow(movie = movie)
            }
        }
    }
}

@Composable
fun MovieRow(
    movie: Movie
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        AsyncImage(
            model = movie.imageUrl,
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .width(width = 75.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = movie.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "Upvotes: ${movie.upvotes}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}