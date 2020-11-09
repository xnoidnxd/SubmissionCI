package com.inoid.submission.favorite.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.inoid.submission.favorite.movie.FavoriteMovieViewModel
import com.inoid.submission.favorite.tvshow.FavoriteTvShowViewModel
import com.inoid.submission.favorite.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteMovieViewModel::class)
    abstract fun bindMovieFavoriteViewModel(viewModel: FavoriteMovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteTvShowViewModel::class)
    abstract fun bindTvShowFavoriteViewModel(viewModel: FavoriteTvShowViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}