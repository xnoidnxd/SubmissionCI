package com.inoid.submission.core.di

import com.inoid.submission.core.data.MovieRepository
import com.inoid.submission.core.domain.repository.IMovieRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieRepository: MovieRepository): IMovieRepository

}