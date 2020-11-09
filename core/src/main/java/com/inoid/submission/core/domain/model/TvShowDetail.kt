package com.inoid.submission.core.domain.model

data class TvShowDetail (

    var id: Int?= null,
    var lastAirDate: String?= null,
    var name: String?= null,
    var popularity: Double?= null,
    var firstAirDate: String?= null,
    var originalLanguage: String?= null,
    var voteAverage: Double?= null,
    var overview: String?= null,
    var posterPath: String?= null,
    var isFavorite :Boolean? = false,
    var voteCount: Long?= null,
    var status: String?= null
)