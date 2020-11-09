package com.inoid.submission.core.domain.model

data class MovieDetail (
    var id: Int?= null,
    var runtime: Int?= null,
    var posterPath: String?= null,
    var originalLanguage: String?= null,
    var title: String?= null,
    var voteAverage: Double?= null,
    var overview: String?= null,
    var releaseDate: String?= null,
    var isFavorite: Boolean? = false,
    var voteCount: Long?= null,
    var popularity: Double?= null,
    var status: String?= null
)



