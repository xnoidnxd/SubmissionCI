package com.inoid.submission.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("last_air_date")
    val lastAirDate: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("popularity")
    val popularity: Double,

    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("original_language")
    val originalLanguage: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    var isFavorite :Boolean = false,

    @field:SerializedName("results")
    val results: List<TvShowResponse>,

    @field: SerializedName("vote_count")
    val voteCount: Long,

    @field:SerializedName("status")
    val status: String


)