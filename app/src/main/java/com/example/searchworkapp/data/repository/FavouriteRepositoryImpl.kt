package com.example.searchworkapp.data.repository

import com.example.searchworkapp.data.source.LocalSource
import com.example.searchworkapp.domain.mapper.toUI
import com.example.searchworkapp.domain.model.VacancyUI
import com.example.searchworkapp.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow

class FavouriteRepositoryImpl(private val source: LocalSource) : FavouriteRepository {

    override val favouriteCountFlow: Flow<Int> = source.favouriteCountFlow

    override suspend fun favourites(): List<VacancyUI> {
        return source.loadFavourites().map { it.toUI() }
    }

}