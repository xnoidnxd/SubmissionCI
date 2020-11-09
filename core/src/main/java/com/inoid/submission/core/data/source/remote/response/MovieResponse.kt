package com.inoid.submission.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

class MovieResponse (
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("runtime")
    val runtime: Int,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("original_language")
    val originalLanguage: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    var isFavorite: Boolean = false,

    @field:SerializedName("results")
    val results: List<MovieResponse>,

    @field: SerializedName("vote_count")
    val voteCount: Long,

    @field: SerializedName("popularity")
    val popularity: Double,

    @field: SerializedName("status")
    val status: String
)