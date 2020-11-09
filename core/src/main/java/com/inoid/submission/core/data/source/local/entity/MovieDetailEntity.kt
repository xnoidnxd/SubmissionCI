package com.inoid.submission.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_movie_detail")
data class MovieDetailEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int?= null,

    @ColumnInfo(name = "runtime")
    var runtime: Int?= null,

    @ColumnInfo(name = "posterPath")
    var posterPath: String?= null,

    @ColumnInfo(name = "originalLanguage")
    var originalLanguage: String?= null,

    @ColumnInfo(name = "title")
    var title: String?= null,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double?= null,

    @ColumnInfo(name = "overview")
    var overview: String?= null,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String?= null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false,

    @ColumnInfo(name = "vote_count")
    val voteCount: Long?= null,

    @ColumnInfo(name = "popularity")
    val popularity: Double?= null,

    @ColumnInfo(name = "status")
    val status: String?= null

)