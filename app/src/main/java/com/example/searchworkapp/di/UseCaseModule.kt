package com.example.searchworkapp.di

import com.example.searchworkapp.domain.useCase.favourite.AddFavouritesUseCase
import com.example.searchworkapp.domain.useCase.favourite.DeleteFavouritesUseCase
import com.example.searchworkapp.domain.useCase.favourite.FavouriteCountFlowUseCase
import com.example.searchworkapp.domain.useCase.favourite.FavouritesUseCase
import com.example.searchworkapp.domain.useCase.offers.OffersUseCase
import com.example.searchworkapp.domain.useCase.vacancies.VacanciesUseCase
import com.example.searchworkapp.domain.useCase.vacancies.VacancyUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory<OffersUseCase> { OffersUseCase(get()) }
    factory<VacanciesUseCase> { VacanciesUseCase(get()) }
    factory<VacancyUseCase> { VacancyUseCase(get()) }
    factory<FavouritesUseCase> { FavouritesUseCase(get()) }
    factory<FavouriteCountFlowUseCase> { FavouriteCountFlowUseCase(get()) }
    factory<AddFavouritesUseCase> { AddFavouritesUseCase(get()) }
    factory<DeleteFavouritesUseCase> { DeleteFavouritesUseCase(get()) }
}