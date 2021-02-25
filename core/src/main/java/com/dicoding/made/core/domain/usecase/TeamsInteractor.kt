package com.dicoding.made.core.domain.usecase

import com.dicoding.made.core.domain.model.Teams
import com.dicoding.made.core.domain.repository.ITeamsRepository

class TeamsInteractor (private val teamsRepository: ITeamsRepository) : TeamsUseCase {
    override fun getAllTeams() = teamsRepository.getAllTeams()

    override fun getFavoriteTeams() = teamsRepository.getFavoriteTeams()

    override fun setFavoriteTeams(teams: Teams, state: Boolean) = teamsRepository.setFavoriteTeams(teams, state)
}

