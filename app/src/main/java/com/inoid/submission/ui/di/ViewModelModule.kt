package com.inoid.submission.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.inoid.submission.ui.detail.movie.DetailMovieViewModel
import com.inoid.submission.ui.detail.tvshow.DetailTvShowViewModel
import com.inoid.submission.ui.movie.airing.MovieAiringViewModel
import com.inoid.submission.ui.movie.popular.MoviePopularViewModel
import com.inoid.submission.ui.movie.search.MovieSearchViewModel
import com.inoid.submission.ui.tvshow.airing.TvShowAiringViewModel
import com.inoid.submission.ui.tvshow.popular.TvShowPopularViewModel
import com.inoid.submission.ui.tvshow.search.TvShowSearchViewModel
import com.inoid.submission.ui.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieAiringViewModel::class)
    abstract fun bindMovieAiringViewModel(viewModel: MovieAiringViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TvShowAiringViewModel::class)
    abstract fun bindTvShowAiringViewModel(viewModel: TvShowAiringViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MoviePopularViewModel::class)
    abstract fun bindMoviePopularViewModel(viewModel: MoviePopularViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TvShowPopularViewModel::class)
    abstract fun bindTvShowPopularViewModel(viewModel: TvShowPopularViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailMovieViewModel::class)
    abstract fun bindDetailMovieViewModel(viewModel: DetailMovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailTvShowViewModel::class)
    abstract fun bindDetailTvShowViewModel(viewModel: DetailTvShowViewModel): ViewModel

    @ExperimentalCoroutinesApi
    @Binds
    @IntoMap
    @ViewModelKey(MovieSearchViewModel::class)
    abstract fun bindMovieSearchViewModel(viewModel: MovieSearchViewModel): ViewModel

    @ExperimentalCoroutinesApi
    @Binds
    @IntoMap
    @ViewModelKey(TvShowSearchViewModel::class)
    abstract fun bindTvShowSearchViewModel(viewModel: TvShowSearchViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}