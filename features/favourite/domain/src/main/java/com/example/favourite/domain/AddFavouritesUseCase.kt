package com.example.favourite.domain


class AddFavouritesUseCase(private val repository: FavouriteRepository) {

    suspend operator fun invoke(id: String) {
        return repository.addFavourites(id)
    }
}