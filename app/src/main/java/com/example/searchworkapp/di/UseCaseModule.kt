package com.example.searchworkapp.di

import com.example.searchworkapp.domain.useCase.FavouriteCountFlowUseCase
import com.example.searchworkapp.domain.useCase.FavouritesUseCase
import com.example.searchworkapp.domain.useCase.OffersUseCase
import com.example.searchworkapp.domain.useCase.VacanciesUseCase
import com.example.searchworkapp.domain.useCase.VacancyUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory<OffersUseCase> { OffersUseCase(get()) }
    factory<VacanciesUseCase> { VacanciesUseCase(get()) }
    factory<VacancyUseCase> { VacancyUseCase(get()) }
    factory<FavouritesUseCase> { FavouritesUseCase(get()) }
    factory<FavouriteCountFlowUseCase> { FavouriteCountFlowUseCase(get()) }
}