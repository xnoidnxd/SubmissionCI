package com.inoid.submission.favorite.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inoid.submission.core.domain.usecase.MovieUseCase
import com.inoid.submission.favorite.di.FeatureScope
import javax.inject.Inject

@FeatureScope
class FavoriteTvShowViewModel @Inject constructor(movieUseCase: MovieUseCase): ViewModel() {

    val favoriteTvShow = movieUseCase.getFavoriteTvShow().asLiveData()

}