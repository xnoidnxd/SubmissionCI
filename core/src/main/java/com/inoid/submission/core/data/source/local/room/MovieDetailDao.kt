package com.inoid.submission.core.data.source.local.room

import androidx.room.*
import com.inoid.submission.core.data.source.local.entity.MovieDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDetailDao {

    @Query("SELECT * FROM table_movie_detail")
    fun getMovie(): Flow<MovieDetailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: MovieDetailEntity)

    @Query("SELECT * FROM table_movie_detail WHERE id = :movieId ")
    fun getMovieById(movieId: Int): Flow<MovieDetailEntity>

    @Query("SELECT * FROM table_movie_detail WHERE isFavorite = 1")
    fun getFavoriteMovie(): Flow<List<MovieDetailEntity>>

    @Update
    fun updateFavoriteMovie(movie: MovieDetailEntity)
}