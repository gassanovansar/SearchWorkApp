package com.example.searchworkapp.data.repository

import com.example.searchworkapp.data.source.LocalSource
import com.example.searchworkapp.data.mapper.toUI
import com.example.models.VacancyUI
import com.example.favourite.domain.FavouriteRepository
import kotlinx.coroutines.flow.Flow

class FavouriteRepositoryImpl(private val source: LocalSource) : FavouriteRepository {

    override val favouriteCountFlow: Flow<Int> = source.favouriteCountFlow

    override suspend fun favourites(): List<VacancyUI> {
        return source.loadFavourites().map { it.toUI() }
    }

    override suspend fun addFavourites(id:String) {
        source.addFavourites(id)
    }

    override suspend fun deleteFavourites(id: String) {
        source.deleteFavourites(id)
    }

}