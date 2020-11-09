package com.inoid.submission.core.domain.usecase

import com.inoid.submission.core.data.Resource
import com.inoid.submission.core.data.source.remote.response.MovieResponse
import com.inoid.submission.core.data.source.remote.response.TvShowResponse
import com.inoid.submission.core.domain.model.*
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {

    // Airing
    fun getAllMovieAiring(): Flow<Resource<List<MovieAiring>>>

    fun getAllTvShowAiring(): Flow<Resource<List<TvShowAiring>>>

    // Popular
    fun getAllMoviePopular(): Flow<Resource<List<MoviePopular>>>

    fun getAllTvShowPopular(): Flow<Resource<List<TvShowPopular>>>


    // Detail
    fun getMovieDetail(movieId: Int): Flow<Resource<MovieDetail>>

    fun getTvShowDetail(tvShowId: Int): Flow<Resource<TvShowDetail>>

    // Favorite
    fun getFavoriteMovie(): Flow<List<MovieDetail>>

    fun setFavoriteMovie(movieDetail: MovieDetail, state: Boolean)

    fun getFavoriteTvShow(): Flow<List<TvShowDetail>>

    fun setFavoriteTvShow(tvShowDetail: TvShowDetail, state: Boolean)

    // Search
    suspend fun searchMovie(movieName: String): Flow<List<MovieResponse>>

    suspend fun searchTvShow(tvShowName: String): Flow<List<TvShowResponse>>

}