package com.inoid.submission.core.data.source.local

import com.inoid.submission.core.data.source.local.entity.*
import com.inoid.submission.core.data.source.local.room.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieAiringDao: MovieAiringDao,
                                          private val tvShowAiringDao: TvShowAiringDao,
                                          private val moviePopularDao: MoviePopularDao,
                                          private val tvShowPopularDao: TvShowPopularDao,
                                          private val movieDetailDao: MovieDetailDao,
                                          private val tvShowDetailDao: TvShowDetailDao) {

    // Airing

    fun getAllAiringMovie(): Flow<List<MovieAiringEntity>> = movieAiringDao.getMovies()

    suspend fun insertAiringMovie(movieList: List<MovieAiringEntity>) = movieAiringDao.insertMovies(movieList)

    fun getAllAiringTvShow(): Flow<List<TvShowAiringEntity>> = tvShowAiringDao.getTvShows()

    suspend fun insertAiringTvShow(tvShowList: List<TvShowAiringEntity>) = tvShowAiringDao.insertTvShows(tvShowList)

    // Popular

    fun getAllPopularMovie(): Flow<List<MoviePopularEntity>> = moviePopularDao.getMovies()

    suspend fun insertPopularMovie(movieList: List<MoviePopularEntity>) = moviePopularDao.insertMovies(movieList)

    fun getAllPopularTvShow(): Flow<List<TvShowPopularEntity>> = tvShowPopularDao.getTvShows()

    suspend fun insertPopularTvShow(tvShowList: List<TvShowPopularEntity>) = tvShowPopularDao.insertTvShows(tvShowList)


    // Detail

    fun getMovieById(movieId: Int): Flow<MovieDetailEntity> = movieDetailDao.getMovieById(movieId)

    suspend fun insertDetailMovie(movie: MovieDetailEntity) = movieDetailDao.insertMovies(movie)

    fun getTvShowById(tvShowId: Int): Flow<TvShowDetailEntity> = tvShowDetailDao.getTvShowById(tvShowId)

    suspend fun insertDetailTvShow(tvShow: TvShowDetailEntity) = tvShowDetailDao.insertTvShows(tvShow)



    // Favorite

    fun getFavoriteMovie(): Flow<List<MovieDetailEntity>> = movieDetailDao.getFavoriteMovie()

    fun setFavoriteMovie(movie: MovieDetailEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDetailDao.updateFavoriteMovie(movie)
    }

    fun getFavoriteTvShow(): Flow<List<TvShowDetailEntity>> = tvShowDetailDao.getFavoriteTvShow()

    fun setFavoriteTvShow(tvShow: TvShowDetailEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        tvShowDetailDao.updateFavoriteTvShow(tvShow)
    }
}