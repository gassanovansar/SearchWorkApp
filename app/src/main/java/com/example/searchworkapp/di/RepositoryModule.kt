package com.example.searchworkapp.di

import com.example.detail.domain.DetailRepository
import com.example.searchworkapp.data.repository.FavouriteRepositoryImpl
import com.example.searchworkapp.data.repository.MainRepositoryImpl
import com.example.favourite.domain.FavouriteRepository
import com.example.main.domain.MainRepository
import com.example.searchworkapp.data.repository.DetailRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
    single<DetailRepository> { DetailRepositoryImpl(get()) }
    single<FavouriteRepository> { FavouriteRepositoryImpl(get()) }
}