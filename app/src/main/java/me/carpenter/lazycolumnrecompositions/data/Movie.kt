package me.carpenter.lazycolumnrecompositions.data

data class Movie(
    val title: String,
    val imageUrl: String,
    val upvotes: Int = 0,
)
