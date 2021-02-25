package com.dicoding.made.detail

import androidx.lifecycle.ViewModel
import com.dicoding.made.core.domain.model.Teams
import com.dicoding.made.core.domain.usecase.TeamsUseCase

class DetailTeamsViewModel (private val teamsUseCase: TeamsUseCase) : ViewModel() {
    fun setFavoriteTeams(teams : Teams, newStatus:Boolean ) =
        teamsUseCase.setFavoriteTeams(teams, newStatus)
}