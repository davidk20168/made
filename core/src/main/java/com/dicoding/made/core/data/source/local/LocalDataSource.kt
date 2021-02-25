package com.dicoding.made.core.data.source.local

import com.dicoding.made.core.data.source.local.entity.TeamsEntity
import com.dicoding.made.core.data.source.local.room.TeamsDao
import kotlinx.coroutines.flow.Flow


class LocalDataSource (private val teamsDao: TeamsDao) {
    fun getAllTeams() : Flow<List<TeamsEntity>> = teamsDao.getAllTourism()

    fun getFavoriteTeams() : Flow<List<TeamsEntity>> = teamsDao.getFavoriteTeams()

    suspend fun insertTeams(teamsList : List<TeamsEntity>) = teamsDao.insertTeams(teamsList)

    fun setFavoriteTeams(teams : TeamsEntity, newState : Boolean) {
        teams.isFavorite = newState
        teamsDao.updateFavoriteTeams(teams)
    }
}