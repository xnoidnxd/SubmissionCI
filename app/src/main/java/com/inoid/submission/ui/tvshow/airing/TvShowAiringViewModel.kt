package com.inoid.submission.ui.tvshow.airing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inoid.submission.core.domain.usecase.MovieUseCase
import javax.inject.Inject

class TvShowAiringViewModel @Inject constructor(movieUseCase: MovieUseCase): ViewModel(){

    val tvShow = movieUseCase.getAllTvShowAiring().asLiveData()
}