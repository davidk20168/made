package com.dicoding.made.core.domain.usecase

import com.dicoding.made.core.data.source.Resource
import com.dicoding.made.core.domain.model.Teams
import kotlinx.coroutines.flow.Flow

interface TeamsUseCase {
    fun getAllTeams() : Flow<Resource<List<Teams>>>
    fun getFavoriteTeams() : Flow<List<Teams>>
    fun setFavoriteTeams(teams : Teams, state : Boolean)
}

