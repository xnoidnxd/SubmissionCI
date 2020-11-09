package com.inoid.submission.ui.detail.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inoid.submission.core.domain.model.MovieDetail
import com.inoid.submission.core.domain.usecase.MovieUseCase
import javax.inject.Inject

class DetailMovieViewModel @Inject constructor(private val movieUseCase: MovieUseCase): ViewModel() {
    fun setDetail(movieId: Int) = movieUseCase.getMovieDetail(movieId).asLiveData()
    fun setFavoriteMovie(movie: MovieDetail, newStatus: Boolean) = movieUseCase.setFavoriteMovie(movie, newStatus)
}