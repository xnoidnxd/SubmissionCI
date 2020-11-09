package com.inoid.submission.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.inoid.submission.core.data.source.local.entity.TvShowAiringEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowAiringDao {

    @Query("SELECT * FROM table_tv_show_airing")
    fun getTvShows(): Flow<List<TvShowAiringEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShows(tvShows: List<TvShowAiringEntity>)

}