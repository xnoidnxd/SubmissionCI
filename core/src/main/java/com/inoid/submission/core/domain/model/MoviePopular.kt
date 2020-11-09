package com.inoid.submission.core.domain.model

data class MoviePopular (
    val id: Int,
    val posterPath: String,
    val originalLanguage: String,
    val title: String,
    val voteAverage: Double,
    val overview: String,
    val popularity: Double
)