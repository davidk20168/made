package com.dicoding.made.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.made.core.domain.usecase.TeamsUseCase

class FavoriteViewModel (teamsUseCase: TeamsUseCase) : ViewModel() {
    val favoriteTeams = teamsUseCase.getFavoriteTeams().asLiveData()
}