package com.inoid.submission.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.inoid.submission.core.data.source.local.entity.MovieAiringEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieAiringDao {

    @Query("SELECT * FROM table_movie_airing")
    fun getMovies(): Flow<List<MovieAiringEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieAiringEntity>)
}