package com.inoid.submission.core.data.source.remote.network

import com.inoid.submission.core.data.source.remote.response.MovieResponse
import com.inoid.submission.core.data.source.remote.response.TvShowResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    // airing
    @GET("/3/movie/now_playing")
    suspend fun getAiringMovies(@Query("api_key") apiKey: String ): MovieResponse

    @GET("/3/tv/airing_today")
    suspend fun getAiringTvShows (@Query("api_key") apiKey: String): TvShowResponse

    // popular
    @GET("/3/movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String ): MovieResponse

    @GET("/3/tv/popular")
    suspend fun getPopularTvShows (@Query("api_key") apiKey: String): TvShowResponse


    // detail
    @GET("/3/movie/{movieId}")
    suspend fun getMovieDetail (@Path("movieId") movieId: Int,
                                @Query("api_key") apiKey: String): MovieResponse

    @GET("/3/tv/{tvShowId}")
    suspend fun getTvShowDetail (@Path("tvShowId") tvShowId: Int,
                         @Query("api_key") apiKey: String): TvShowResponse


    // Search
    @GET("/3/search/movie")
    suspend fun searchMovie (@Query("api_key") apiKey: String,
                             @Query("query") movieName: String): MovieResponse

    @GET("/3/search/tv")
    suspend fun searchTvShow (@Query("api_key") apiKey: String,
                              @Query("query") tvShowName: String): TvShowResponse
}