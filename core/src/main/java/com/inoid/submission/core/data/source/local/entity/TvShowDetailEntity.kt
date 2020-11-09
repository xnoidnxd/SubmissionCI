package com.inoid.submission.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_tv_show_detail")
data class TvShowDetailEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int?= null,

    @ColumnInfo(name = "lastAirDate")
    var lastAirDate: String?= null,

    @ColumnInfo(name = "name")
    var name: String?= null,

    @ColumnInfo(name = "popularity")
    var popularity: Double?= null,

    @ColumnInfo(name = "firstAirDate")
    var firstAirDate: String?= null,

    @ColumnInfo(name = "originalLanguage")
    var originalLanguage: String?= null,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double?= null,

    @ColumnInfo(name = "overview")
    var overview: String?= null,

    @ColumnInfo(name = "posterPath")
    var posterPath: String?= null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false,

    @ColumnInfo(name = "vote_count")
    val voteCount: Long?= null,

    @ColumnInfo(name = "status")
    val status: String?= null

)