package com.example.searchworkapp.domain.useCase.favourite

import com.example.searchworkapp.domain.repository.FavouriteRepository

class AddFavouritesUseCase(private val repository: FavouriteRepository) {

    suspend operator fun invoke(id: String) {
        return repository.addFavourites(id)
    }
}