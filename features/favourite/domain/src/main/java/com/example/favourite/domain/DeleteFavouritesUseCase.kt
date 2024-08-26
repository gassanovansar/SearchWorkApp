package com.example.favourite.domain

import com.example.corekt.BaseUseCase


class DeleteFavouritesUseCase(private val repository: FavouriteRepository) :
    BaseUseCase<DeleteFavouritesUseCase.Params, Unit>() {

    class Params(val id: String)

    override suspend fun execute(params: Params) {
        return repository.deleteFavourites(params.id)
    }
}