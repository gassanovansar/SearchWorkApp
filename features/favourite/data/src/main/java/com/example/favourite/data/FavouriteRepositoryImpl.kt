package com.example.favourite.data

import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.corekt.apiCall
import com.example.source.LocalSource
import com.example.models.mappers.toUI
import com.example.favourite.domain.FavouriteRepository
import com.example.models.domain.VacancyUI
import kotlinx.coroutines.flow.Flow

class FavouriteRepositoryImpl(private val source: LocalSource) : FavouriteRepository {

    override val favouriteCountFlow: Flow<Int> = source.favouriteCountFlow

    override suspend fun favourites(): Either<Failure, List<VacancyUI>> {
        return apiCall(call = {
            source.loadFavourites()
        }, mapResponse = {
            it.map { it.toUI() }
        })
    }

    override suspend fun addFavourites(id: String): Either<Failure, Unit> {
        return apiCall {
            source.addFavourites(id)
        }
    }

    override suspend fun deleteFavourites(id: String): Either<Failure, Unit> {
        return apiCall {
            source.deleteFavourites(id)
        }
    }

}