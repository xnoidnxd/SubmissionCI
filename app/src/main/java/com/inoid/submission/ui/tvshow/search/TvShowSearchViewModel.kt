package com.inoid.submission.ui.tvshow.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.inoid.submission.core.data.source.remote.response.TvShowResponse
import com.inoid.submission.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class TvShowSearchViewModel @Inject constructor(private val movieUseCase: MovieUseCase): ViewModel() {

    var result : LiveData<List<TvShowResponse>>? = null

    private val _searchState = MutableStateFlow("")


    fun setTvShowName(tvShowName: String) {
        this._searchState.value = tvShowName
    }

    fun searchTvShow(){
        viewModelScope.launch {
            result = movieUseCase.searchTvShow(_searchState.value).asLiveData()
        }
    }
}