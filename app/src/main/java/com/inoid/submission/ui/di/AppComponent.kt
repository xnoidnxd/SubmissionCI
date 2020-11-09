package com.inoid.submission.ui.di

import com.inoid.submission.core.di.CoreComponent
import com.inoid.submission.ui.detail.movie.DetailMovieFragment
import com.inoid.submission.ui.detail.tvshow.DetailTvShowFragment
import com.inoid.submission.ui.movie.airing.MovieAiringFragment
import com.inoid.submission.ui.movie.popular.MoviePopularFragment
import com.inoid.submission.ui.movie.search.MovieSearchFragment
import com.inoid.submission.ui.tvshow.airing.TvShowAiringFragment
import com.inoid.submission.ui.tvshow.popular.TvShowPopularFragment
import com.inoid.submission.ui.tvshow.search.TvShowSearchFragment
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: MovieAiringFragment)
    fun inject(fragment: TvShowAiringFragment)
    fun inject(fragment: MoviePopularFragment)
    fun inject(fragment: TvShowPopularFragment)

    fun inject(fragment: DetailMovieFragment)
    fun inject(fragment: DetailTvShowFragment)

    @ExperimentalCoroutinesApi
    fun inject(fragment: MovieSearchFragment)
    @ExperimentalCoroutinesApi
    fun inject(fragment: TvShowSearchFragment)
    
}