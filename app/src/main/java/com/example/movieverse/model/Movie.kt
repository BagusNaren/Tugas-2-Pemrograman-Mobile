package com.example.movieverse.model

data class Movie(

    val id: Int,

    val title: String,

    val genre: String,

    val rating: Double,

    val year: String,

    val duration: String,

    val imageResId: Int,

    val description: String,

    var isFavorite: Boolean = false
)