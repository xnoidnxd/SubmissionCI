package com.inoid.submission.ui.tvshow.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inoid.submission.core.domain.usecase.MovieUseCase
import javax.inject.Inject

class TvShowPopularViewModel @Inject constructor(movieUseCase: MovieUseCase): ViewModel(){

    val tvShow = movieUseCase.getAllTvShowPopular().asLiveData()
}