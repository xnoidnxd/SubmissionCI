package com.inoid.submission.favorite.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inoid.submission.core.domain.usecase.MovieUseCase
import com.inoid.submission.favorite.di.FeatureScope
import javax.inject.Inject

@FeatureScope
class FavoriteMovieViewModel @Inject constructor(movieUseCase: MovieUseCase): ViewModel() {

    val favoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}