package com.example.favourite.domain


class DeleteFavouritesUseCase(private val repository: FavouriteRepository) {

    suspend operator fun invoke(id: String) {
        return repository.deleteFavourites(id)
    }
}