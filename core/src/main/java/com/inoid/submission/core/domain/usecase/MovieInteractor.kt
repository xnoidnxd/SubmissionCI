package com.inoid.submission.core.domain.usecase

import com.inoid.submission.core.data.source.remote.response.TvShowResponse
import com.inoid.submission.core.domain.model.MovieDetail
import com.inoid.submission.core.domain.model.TvShowDetail
import com.inoid.submission.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovieAiring() = movieRepository.getAllMovieAiring()

    override fun getAllTvShowAiring() = movieRepository.getAllTvShowAiring()

    override fun getAllMoviePopular() = movieRepository.getAllMoviePopular()

    override fun getAllTvShowPopular() = movieRepository.getAllTvShowPopular()

    override fun getMovieDetail(movieId: Int) = movieRepository.getMovieDetail(movieId)

    override fun getTvShowDetail(tvShowId: Int) = movieRepository.getTvShowDetail(tvShowId)

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movieDetail: MovieDetail, state: Boolean) = movieRepository.setFavoriteMovie(movieDetail, state)

    override fun getFavoriteTvShow() = movieRepository.getFavoriteTvShow()

    override fun setFavoriteTvShow(tvShowDetail: TvShowDetail, state: Boolean) = movieRepository.setFavoriteTvShow(tvShowDetail, state)

    override suspend fun searchMovie(movieName: String) = movieRepository.searchMovie(movieName)

    override suspend fun searchTvShow(tvShowName: String): Flow<List<TvShowResponse>> = movieRepository.searchTvShow(tvShowName)
}