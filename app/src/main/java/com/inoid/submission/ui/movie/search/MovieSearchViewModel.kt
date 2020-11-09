package com.inoid.submission.ui.movie.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.inoid.submission.core.data.source.remote.response.MovieResponse
import com.inoid.submission.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MovieSearchViewModel @Inject constructor(private val movieUseCase: MovieUseCase): ViewModel(){

    var result : LiveData<List<MovieResponse>>? = null

    private val _searchState = MutableStateFlow("")

    fun setMovieName(movieName: String) {
        this._searchState.value = movieName
    }

    fun searchMovie(){
        viewModelScope.launch {
            result = movieUseCase.searchMovie(_searchState.value).asLiveData()
        }
    }
}