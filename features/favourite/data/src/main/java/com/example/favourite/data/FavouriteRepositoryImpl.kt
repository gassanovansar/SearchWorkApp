package com.example.favourite.data

import com.example.source.LocalSource
import com.example.models.mappers.toUI
import com.example.favourite.domain.FavouriteRepository
import com.example.models.domain.VacancyUI
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