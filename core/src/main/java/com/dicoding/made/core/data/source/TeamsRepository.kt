package com.dicoding.made.core.data.source

import com.dicoding.made.core.data.source.local.LocalDataSource
import com.dicoding.made.core.data.source.remote.RemoteDataSource
import com.dicoding.made.core.data.source.remote.network.ApiResponse
import com.dicoding.made.core.data.source.remote.response.TeamsResponse
import com.dicoding.made.core.domain.model.Teams
import com.dicoding.made.core.domain.repository.ITeamsRepository
import com.dicoding.made.core.utils.AppExecutors
import com.dicoding.made.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TeamsRepository (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors : AppExecutors
) : ITeamsRepository {

    override fun getAllTeams(): Flow<Resource<List<Teams>>> =
        object : NetworkBoundResource<List<Teams>, List<TeamsResponse>>() {
            override fun loadFromDB(): Flow<List<Teams>> {
                return localDataSource.getAllTeams().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Teams>?): Boolean = data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TeamsResponse>>> =
                remoteDataSource.getAllTeams()

            override suspend fun saveCallResult(data: List<TeamsResponse>) {
                val teamsList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTeams(teamsList)
            }
        }.asFlow()



    override fun getFavoriteTeams(): Flow<List<Teams>> {
        return localDataSource.getFavoriteTeams().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTeams(teams: Teams, state: Boolean) {
        val teamsEntity = DataMapper.mapDomainToEntity(teams)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTeams(teamsEntity,state) }
    }


}