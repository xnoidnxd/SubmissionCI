package com.inoid.submission.ui.di

import com.inoid.submission.core.domain.usecase.MovieInteractor
import com.inoid.submission.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideMovieUseCase(movieInteractor: MovieInteractor): MovieUseCase

}