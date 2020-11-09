package com.inoid.submission.core.domain.model

data class TvShowAiring (
    val id: Int,
    val name: String,
    val originalLanguage: String,
    val voteAverage: Double,
    val overview: String,
    val posterPath: String?,
    val popularity: Double
)