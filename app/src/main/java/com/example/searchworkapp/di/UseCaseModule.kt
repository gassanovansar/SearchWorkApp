package com.example.searchworkapp.di

import com.example.searchworkapp.domain.useCase.OffersUseCase
import com.example.searchworkapp.domain.useCase.VacanciesUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory<OffersUseCase> { OffersUseCase(get()) }
    factory<VacanciesUseCase> { VacanciesUseCase(get()) }
}