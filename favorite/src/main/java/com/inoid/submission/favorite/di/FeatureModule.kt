package com.inoid.submission.favorite.di

import com.inoid.submission.core.domain.usecase.MovieInteractor
import com.inoid.submission.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class FeatureModule {

    @Binds
    abstract fun provideMovieUseCase(movieInteractor: MovieInteractor): MovieUseCase
}