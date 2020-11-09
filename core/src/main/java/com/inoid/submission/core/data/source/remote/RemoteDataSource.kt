package com.inoid.submission.core.data.source.remote

import android.util.Log
import com.inoid.submission.core.BuildConfig.API_KEY
import com.inoid.submission.core.data.source.remote.network.ApiResponse
import com.inoid.submission.core.data.source.remote.network.ApiService
import com.inoid.submission.core.data.source.remote.response.MovieResponse
import com.inoid.submission.core.data.source.remote.response.TvShowResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    private val apiKey = API_KEY

    suspend fun getAiringMovie(): Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = apiService.getAiringMovies(apiKey)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString() )
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAiringTvShow(): Flow<ApiResponse<List<TvShowResponse>>> {
        return flow {
            try {
                val response = apiService.getAiringTvShows(apiKey)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString() )
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPopularMovie(): Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = apiService.getPopularMovies(apiKey)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString() )
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPopularTvShow(): Flow<ApiResponse<List<TvShowResponse>>> {
        return flow {
            try {
                val response = apiService.getPopularTvShows(apiKey)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString() )
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMovieDetail(movieId: Int): Flow<ApiResponse<MovieResponse>> {
        return flow {
            try {
                Log.d("getMovieDetail", "getMovieDetail: getMovie")
                val response = apiService.getMovieDetail(movieId, apiKey)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString() )
            }
        }.flowOn(Dispatchers.IO)
    }


    suspend fun getTvShowDetail(tvShowId: Int): Flow<ApiResponse<TvShowResponse>> {
        return flow {
            try {
                val response = apiService.getTvShowDetail(tvShowId, apiKey)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString() )
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun searchMovie(movieName: String): Flow<List<MovieResponse>> {
        return flow {
            val response = apiService.searchMovie(apiKey, movieName)
            val dataArray = response.results

            if (dataArray.isNotEmpty()) {
                emit(response.results)
            } else {
                emit(emptyList())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun searchTvShow(tvShowName: String): Flow<List<TvShowResponse>> {
        return flow {
            val response = apiService.searchTvShow(apiKey, tvShowName)
            val dataArray = response.results
            if (dataArray.isNotEmpty()) {
                emit(response.results)
            } else {
                emit(emptyList())
            }
        }.flowOn(Dispatchers.IO)
    }
}