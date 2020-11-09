package com.inoid.submission.core.domain

import com.inoid.submission.core.data.MovieRepository
import com.inoid.submission.core.data.Resource
import com.inoid.submission.core.domain.model.MovieAiring
import com.inoid.submission.core.domain.model.MovieDetail
import com.inoid.submission.core.domain.usecase.MovieInteractor
import com.inoid.submission.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieUseCaseTest {

    private lateinit var movieUseCase: MovieUseCase

    @Mock private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp(){
        movieUseCase = MovieInteractor(movieRepository)
    }

    @Test fun `should get data from repository`() {
        movieUseCase.getMovieDetail(ID)
        verify(movieRepository).getMovieDetail(ID)
        verifyNoMoreInteractions(movieRepository)
    }

    companion object {
        const val ID = 635302
    }
}