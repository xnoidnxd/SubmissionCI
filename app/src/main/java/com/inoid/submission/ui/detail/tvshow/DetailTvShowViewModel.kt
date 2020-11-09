package com.inoid.submission.ui.detail.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inoid.submission.core.domain.model.TvShowDetail
import com.inoid.submission.core.domain.usecase.MovieUseCase
import javax.inject.Inject

class DetailTvShowViewModel @Inject constructor(private val movieUseCase: MovieUseCase): ViewModel() {
    fun setDetail(tvShowId: Int) = movieUseCase.getTvShowDetail(tvShowId).asLiveData()
    fun setFavoriteTvShow(tvShow: TvShowDetail, newStatus: Boolean) = movieUseCase.setFavoriteTvShow(tvShow, newStatus)
}