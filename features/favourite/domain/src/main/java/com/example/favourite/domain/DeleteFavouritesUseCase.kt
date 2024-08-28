package com.example.favourite.domain

import com.example.corekt.BaseUseCase
import com.example.corekt.Either
import com.example.corekt.Failure
import kotlinx.coroutines.CoroutineScope


class DeleteFavouritesUseCase(private val repository: FavouriteRepository) :
    BaseUseCase<DeleteFavouritesUseCase.Params, Unit>() {

    class Params(val id: String)

    override suspend fun execute(params: Params, scope: CoroutineScope): Either<Failure, Unit> {
        return repository.deleteFavourites(params.id)
    }
}