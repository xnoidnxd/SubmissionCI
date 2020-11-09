package com.inoid.submission.ui.movie.airing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inoid.submission.core.domain.usecase.MovieUseCase
import javax.inject.Inject

class MovieAiringViewModel @Inject constructor (movieUseCase: MovieUseCase): ViewModel() {

    val movie = movieUseCase.getAllMovieAiring().asLiveData()
}