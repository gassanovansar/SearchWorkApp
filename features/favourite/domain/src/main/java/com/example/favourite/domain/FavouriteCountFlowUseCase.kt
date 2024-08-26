package com.example.favourite.domain

class FavouriteCountFlowUseCase(private val repository: FavouriteRepository) {

    operator fun invoke() = repository.favouriteCountFlow
}