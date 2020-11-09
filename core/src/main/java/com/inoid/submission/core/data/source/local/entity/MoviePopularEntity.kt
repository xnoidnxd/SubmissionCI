package com.inoid.submission.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_movie_popular")
data class MoviePopularEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "posterPath")
    var posterPath: String,

    @ColumnInfo(name = "originalLanguage")
    var originalLanguage: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "popularity")
    val popularity: Double
)