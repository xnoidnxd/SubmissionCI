package com.inoid.submission.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.inoid.submission.core.data.source.local.entity.*

@Database(entities = [
    MovieAiringEntity::class,
    TvShowAiringEntity::class,
    MoviePopularEntity::class,
    TvShowPopularEntity::class,
    MovieDetailEntity::class,
    TvShowDetailEntity::class],
    version = 1,
    exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieAiringDao(): MovieAiringDao
    abstract fun tvShowAiringDao(): TvShowAiringDao
    abstract fun moviePopularDao(): MoviePopularDao
    abstract fun tvShowPopularDao(): TvShowPopularDao
    abstract fun movieDetailDao(): MovieDetailDao
    abstract fun tvShowDetailDao(): TvShowDetailDao

}