package com.example.favourite.domain

import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.models.domain.VacancyUI
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {

    val favouriteCountFlow: Flow<Int>
    suspend fun favourites(): Either<Failure, List<VacancyUI>>
    suspend fun addFavourites(id: String): Either<Failure, Unit>
    suspend fun deleteFavourites(id: String): Either<Failure, Unit>
}