package com.inoid.submission.ui.movie.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inoid.submission.core.domain.usecase.MovieUseCase
import javax.inject.Inject

class MoviePopularViewModel @Inject constructor (movieUseCase: MovieUseCase): ViewModel() {
    val movie = movieUseCase.getAllMoviePopular().asLiveData()
}