package com.inoid.submission.core.data.source.local.room

import androidx.room.*
import com.inoid.submission.core.data.source.local.entity.TvShowDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowDetailDao {

    @Query("SELECT * FROM table_tv_show_detail")
    fun getTvShows(): Flow<List<TvShowDetailEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShows(tvShows: TvShowDetailEntity)

    @Query("SELECT * FROM table_tv_show_detail WHERE id = :tvShowId")
    fun getTvShowById(tvShowId: Int): Flow<TvShowDetailEntity>

    @Query("SELECT * FROM table_tv_show_detail WHERE isFavorite = 1")
    fun getFavoriteTvShow(): Flow<List<TvShowDetailEntity>>

    @Update
    fun updateFavoriteTvShow(tvShow: TvShowDetailEntity)
}