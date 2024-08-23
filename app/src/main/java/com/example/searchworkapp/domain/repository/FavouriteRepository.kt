package com.example.searchworkapp.domain.repository

import com.example.searchworkapp.domain.model.VacancyUI
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {

    val favouriteCountFlow: Flow<Int>
    suspend fun favourites(): List<VacancyUI>
}