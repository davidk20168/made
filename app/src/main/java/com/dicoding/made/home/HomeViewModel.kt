package com.dicoding.made.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.made.core.domain.usecase.TeamsUseCase

class HomeViewModel (teamsUseCase: TeamsUseCase) : ViewModel() {
    val teams = teamsUseCase.getAllTeams().asLiveData()
}