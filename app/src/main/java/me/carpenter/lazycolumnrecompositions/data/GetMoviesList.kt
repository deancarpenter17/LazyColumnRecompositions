package me.carpenter.lazycolumnrecompositions.data

import kotlinx.coroutines.delay

suspend fun getMoviesList(): List<Movie> {
    // Loading movies...
    delay(2000)
    return listOf(
        Movie(
            title = "Anyone But You",
            imageUrl = "https://image.tmdb.org/t/p/original/yRt7MGBElkLQOYRvLTT1b3B1rcp.jpg",
        ),
        Movie(
            title = "Wonka",
            imageUrl = "https://image.tmdb.org/t/p/original/qhb1qOilapbapxWQn9jtRCMwXJF.jpg",
        ),
        Movie(
            title = "The Beekeeper",
            imageUrl = "https://image.tmdb.org/t/p/original/A7EByudX0eOzlkQ2FIbogzyazm2.jpg",
        ),
        Movie(
            title = "Society of the Snow",
            imageUrl = "https://image.tmdb.org/t/p/original/2e853FDVSIso600RqAMunPxiZjq.jpg",
        ),
        Movie(
            title = "Aquaman and the Lost Kingdom",
            imageUrl = "https://image.tmdb.org/t/p/original/8xV47NDrjdZDpkVcCFqkdHa3T0C.jpg",
        ),
        Movie(
            title = "Spider-Man: Across the Spider-Verse",
            imageUrl = "https://image.tmdb.org/t/p/original/8Vt6mWEReuy4Of61Lnj5Xj704m8.jpg",
        ),
        Movie(
            title = "The Hunger Games: The Ballad of Songbirds & Snakes",
            imageUrl = "https://image.tmdb.org/t/p/original/mBaXZ95R2OxueZhvQbcEWy2DqyO.jpg",
        ),
        Movie(
            title = "Oppenheimer",
            imageUrl = "https://image.tmdb.org/t/p/original/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg",
        ),
        Movie(
            title = "Trolls Band Together",
            imageUrl = "https://image.tmdb.org/t/p/original/bkpPTZUdq31UGDovmszsg2CchiI.jpg",
        ),
        Movie(
            title = "The Family Plan",
            imageUrl = "https://image.tmdb.org/t/p/original/a6syn9qcU4a54Lmi3JoIr1XvhFU.jpg",
        ),
    )
}