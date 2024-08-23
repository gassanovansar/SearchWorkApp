package com.example.searchworkapp.di

import com.example.searchworkapp.data.repository.FavouriteRepositoryImpl
import com.example.searchworkapp.data.repository.OffersRepositoryImpl
import com.example.searchworkapp.data.repository.VacanciesRepositoryImpl
import com.example.searchworkapp.domain.repository.FavouriteRepository
import com.example.searchworkapp.domain.repository.OffersRepository
import com.example.searchworkapp.domain.repository.VacanciesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<OffersRepository> { OffersRepositoryImpl(get()) }
    single<VacanciesRepository> { VacanciesRepositoryImpl(get()) }
    single<FavouriteRepository> { FavouriteRepositoryImpl(get()) }
}