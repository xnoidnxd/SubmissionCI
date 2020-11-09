package com.inoid.submission.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.inoid.submission.core.data.source.local.entity.TvShowPopularEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowPopularDao {

    @Query("SELECT * FROM table_tv_show_popular")
    fun getTvShows(): Flow<List<TvShowPopularEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShows(tvShows: List<TvShowPopularEntity>)

}