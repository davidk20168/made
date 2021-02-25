package com.dicoding.made.di

import com.dicoding.made.core.domain.usecase.TeamsInteractor
import com.dicoding.made.core.domain.usecase.TeamsUseCase
import com.dicoding.made.detail.DetailTeamsViewModel
import com.dicoding.made.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TeamsUseCase> { TeamsInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailTeamsViewModel(get()) }
}