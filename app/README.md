restartable skippable scheme("[androidx.compose.ui.UiComposable, [androidx.compose.ui.UiComposable], [androidx.compose.ui.UiComposable], [androidx.compose.ui.UiComposable]]") fun ViewStateScreen(
stable modifier: Modifier? = @static Companion.fillMaxSize()
stable viewState: ViewState<T, E>
stable onLoading: Function2<Composer, Int, Unit>? = @static ComposableSingletons$ViewStateKt.lambda-1
stable onError: Function3<E, Composer, Int, Unit>? = @static ComposableSingletons$ViewStateKt.lambda-2
stable onLoaded: Function3<T, Composer, Int, Unit>
)
restartable skippable scheme("[androidx.compose.ui.UiComposable]") fun DefaultLoadingScreen()
restartable skippable scheme("[androidx.compose.ui.UiComposable]") fun DefaultErrorScreen()
restartable scheme("[androidx.compose.ui.UiComposable]") fun MoviesScreen(
unstable viewModel: MoviesViewModel
)
restartable scheme("[androidx.compose.ui.UiComposable]") fun MoviesList(
unstable movies: List<Movie>
stable modifier: Modifier? = @static Companion
)
restartable skippable scheme("[androidx.compose.ui.UiComposable]") fun MovieRow(
stable movie: Movie
)
restartable skippable scheme("[0, [0]]") fun LazyColumnRecompositionsTheme(
stable darkTheme: Boolean = @dynamic isSystemInDarkTheme($composer, 0)
stable dynamicColor: Boolean = @static true
stable content: Function2<Composer, Int, Unit>
)