package com.example.favourite.domain

import com.example.corekt.BaseUseCase


class AddFavouritesUseCase(private val repository: FavouriteRepository) :
    BaseUseCase<AddFavouritesUseCase.Params, Unit>() {
    class Params(val id: String)


    override suspend fun execute(params: Params) {
        return repository.addFavourites(params.id)
    }
}