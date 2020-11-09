package com.inoid.submission.core.utils

import com.inoid.submission.core.data.source.local.entity.*
import com.inoid.submission.core.data.source.remote.response.MovieResponse
import com.inoid.submission.core.data.source.remote.response.TvShowResponse
import com.inoid.submission.core.domain.model.*

object DataMapper {

    // MovieAiring
    fun mapMAResponseToEntities(input: List<MovieResponse>): List<MovieAiringEntity> {

        val movieAiringList = ArrayList<MovieAiringEntity>()

        input.map {
            val movie = MovieAiringEntity(
                id = it.id,
                posterPath = it.posterPath,
                originalLanguage = it.originalLanguage,
                title = it.title,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity
            )
            movieAiringList.add(movie)
        }
        return movieAiringList
    }

    fun mapMAEntitiesToDomain(input: List<MovieAiringEntity>): List<MovieAiring> =
        input.map {
            MovieAiring(
                id = it.id,
                posterPath = it.posterPath,
                originalLanguage = it.originalLanguage,
                title = it.title,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity
            )
        }

    // TvShowAiring
    fun mapTAResponseToEntities(input: List<TvShowResponse>): List<TvShowAiringEntity> {

        val tvShowAiringList = ArrayList<TvShowAiringEntity>()

        input.map {
            val tvShow = TvShowAiringEntity(
                id = it.id,
                name = it.name,
                originalLanguage = it.originalLanguage,
                voteAverage = it.voteAverage,
                overview = it.overview,
                posterPath = it.posterPath,
                popularity = it.popularity
            )
            tvShowAiringList.add(tvShow)
        }
        return tvShowAiringList
    }

    fun mapTAEntitiesToDomain(input: List<TvShowAiringEntity>): List<TvShowAiring> =
        input.map {
            TvShowAiring(
                id = it.id,
                name = it.name,
                originalLanguage = it.originalLanguage,
                voteAverage = it.voteAverage,
                overview = it.overview,
                posterPath = it.posterPath,
                popularity = it.popularity
            )
        }

    // MoviePopular
    fun mapMPResponseToEntities(input: List<MovieResponse>): List<MoviePopularEntity> {

        val moviePopularList = ArrayList<MoviePopularEntity>()

        input.map {
            val movie = MoviePopularEntity(
                id = it.id,
                posterPath = it.posterPath,
                originalLanguage = it.originalLanguage,
                title = it.title,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity
            )
            moviePopularList.add(movie)
        }
        return moviePopularList
    }

    fun mapMPEntitiesToDomain(input: List<MoviePopularEntity>): List<MoviePopular> =
        input.map {
            MoviePopular(
                id = it.id,
                posterPath = it.posterPath,
                originalLanguage = it.originalLanguage,
                title = it.title,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity
            )
        }

    // TvShowPopular
    fun mapTPResponseToEntities(input: List<TvShowResponse>): List<TvShowPopularEntity> {

        val tvShowPopularList = ArrayList<TvShowPopularEntity>()

        input.map {
            val tvShow = TvShowPopularEntity(
                id = it.id,
                name = it.name,
                originalLanguage = it.originalLanguage,
                voteAverage = it.voteAverage,
                overview = it.overview,
                posterPath = it.posterPath,
                popularity = it.popularity
            )
            tvShowPopularList.add(tvShow)
        }
        return tvShowPopularList
    }

    fun mapTPEntitiesToDomain(input: List<TvShowPopularEntity>): List<TvShowPopular> =
        input.map {
            TvShowPopular(
                id = it.id,
                name = it.name,
                originalLanguage = it.originalLanguage,
                voteAverage = it.voteAverage,
                overview = it.overview,
                posterPath = it.posterPath,
                popularity = it.popularity
            )
        }





    fun mapMDDomainToEntity(input: MovieDetail) = MovieDetailEntity(
        id = input.id,
        runtime = input.runtime,
        posterPath = input.posterPath,
        originalLanguage = input.originalLanguage,
        title = input.title,
        voteAverage = input.voteAverage,
        overview = input.overview,
        releaseDate = input.releaseDate,
        isFavorite = input.isFavorite!!,
        voteCount = input.voteCount,
        popularity = input.popularity,
        status = input.status
    )


    fun mapTDDomainToEntity(input: TvShowDetail) = TvShowDetailEntity(
        id = input.id,
        lastAirDate = input.lastAirDate,
        name = input.name,
        popularity = input.popularity,
        firstAirDate = input.firstAirDate,
        originalLanguage = input.originalLanguage,
        voteAverage = input.voteAverage,
        overview = input.overview,
        posterPath = input.posterPath,
        isFavorite = input.isFavorite!!,
        voteCount = input.voteCount,
        status = input.status
    )



    // MD TRY
    fun mapMDResponseToEntities1(input: MovieResponse) =
        MovieDetailEntity(
            id = input.id,
            runtime = input.runtime,
            posterPath = input.posterPath,
            originalLanguage = input.originalLanguage,
            title = input.title,
            voteAverage = input.voteAverage,
            overview = input.overview,
            releaseDate = input.releaseDate,
            isFavorite = false,
            voteCount = input.voteCount,
            popularity = input.popularity,
            status = input.status
        )


    fun mapMDEntitiesToDomain1(input: MovieDetailEntity?) =
        MovieDetail(
            id = input?.id,
            runtime = input?.runtime,
            posterPath = input?.posterPath,
            originalLanguage = input?.originalLanguage,
            title = input?.title,
            voteAverage = input?.voteAverage,
            overview = input?.overview,
            releaseDate = input?.releaseDate,
            isFavorite = input?.isFavorite,
            voteCount = input?.voteCount,
            popularity = input?.popularity,
            status = input?.status
        )

    fun mapMDEntitiesToDomainList(input: List<MovieDetailEntity>): List<MovieDetail> =
        input.map {
            MovieDetail(
                id = it.id,
                posterPath = it.posterPath,
                originalLanguage = it.originalLanguage,
                title = it.title,
                voteAverage = it.voteAverage,
                overview = it.overview,
                isFavorite = it.isFavorite,
                popularity = it.popularity
            )
        }

    // TD TRY

    fun mapTDResponseToEntities1(input: TvShowResponse)=
        TvShowDetailEntity(
            id = input.id,
            lastAirDate = input.lastAirDate,
            name = input.name,
            popularity = input.popularity,
            firstAirDate = input.firstAirDate,
            originalLanguage = input.originalLanguage,
            voteAverage = input.voteAverage,
            overview = input.overview,
            posterPath = input.posterPath,
            isFavorite = false,
            voteCount = input.voteCount,
            status = input.status)

    fun mapTDEntitiesToDomain1(input: TvShowDetailEntity?) =
        TvShowDetail(
            id = input?.id,
            lastAirDate = input?.lastAirDate,
            name = input?.name,
            popularity = input?.popularity,
            firstAirDate = input?.firstAirDate,
            originalLanguage = input?.originalLanguage,
            voteAverage = input?.voteAverage,
            overview = input?.overview,
            posterPath = input?.posterPath,
            isFavorite = input?.isFavorite,
            voteCount = input?.voteCount,
            status = input?.status
        )

    fun mapTDEntitiesToDomainList(input: List<TvShowDetailEntity>): List<TvShowDetail> =
        input.map {
            TvShowDetail(
                id = it.id,
                posterPath = it.posterPath,
                originalLanguage = it.originalLanguage,
                name = it.name,
                voteAverage = it.voteAverage,
                overview = it.overview,
                isFavorite = it.isFavorite,
                popularity = it.popularity
            )
        }
}