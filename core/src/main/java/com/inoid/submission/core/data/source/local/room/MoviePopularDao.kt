package com.inoid.submission.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.inoid.submission.core.data.source.local.entity.MoviePopularEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviePopularDao {

    @Query("SELECT * FROM table_movie_popular")
    fun getMovies(): Flow<List<MoviePopularEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MoviePopularEntity>)

}