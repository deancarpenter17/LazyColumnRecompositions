package me.carpenter.lazycolumnrecompositions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.carpenter.lazycolumnrecompositions.ui.MoviesScreen
import me.carpenter.lazycolumnrecompositions.ui.theme.LazyColumnRecompositionsTheme
import me.carpenter.lazycolumnrecompositions.vm.MoviesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val moviesViewModel = MoviesViewModel()
        setContent {
            LazyColumnRecompositionsTheme {
                // A surface container using the 'background' color from the theme
                MoviesScreen(
                    moviesViewModel
                )
            }
        }
    }
}