package com.inoid.submission.core.di

import android.content.Context
import androidx.room.Room
import com.inoid.submission.core.data.source.local.room.*
import dagger.Module
import dagger.Provides
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MovieDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java, "Movie.db")
            .fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }


    @Provides
    fun provideMovieAiringDao(database: MovieDatabase): MovieAiringDao = database.movieAiringDao()

    @Provides
    fun provideTvShowAiringDao(database: MovieDatabase): TvShowAiringDao = database.tvShowAiringDao()

    @Provides
    fun provideMoviePopularDao(database: MovieDatabase): MoviePopularDao = database.moviePopularDao()

    @Provides
    fun provideTvShowPopularDao(database: MovieDatabase): TvShowPopularDao = database.tvShowPopularDao()

    @Provides
    fun provideMovieDetailDao(database: MovieDatabase): MovieDetailDao = database.movieDetailDao()

    @Provides
    fun provideTvShowDetailDao(database: MovieDatabase): TvShowDetailDao = database.tvShowDetailDao()




}