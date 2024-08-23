package com.example.favourite.domain

import com.example.models.VacancyUI
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {

    val favouriteCountFlow: Flow<Int>
    suspend fun favourites(): List<VacancyUI>
    suspend fun addFavourites(id: String)
    suspend fun deleteFavourites(id: String)
}