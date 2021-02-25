package com.dicoding.made.core.data.source.local.room

import androidx.room.*
import com.dicoding.made.core.data.source.local.entity.TeamsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamsDao {
    @Query("SELECT * FROM teams")
    fun getAllTourism(): Flow<List<TeamsEntity>>

    @Query("SELECT * FROM teams where isFavorite = 1")
    fun getFavoriteTeams():Flow<List<TeamsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeams(teams : List<TeamsEntity>)

    @Update
    fun updateFavoriteTeams(teams : TeamsEntity)
}