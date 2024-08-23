package com.example.favourite.domain

import kotlinx.coroutines.flow.Flow

class FavouriteCountFlowUseCase(private val repository: FavouriteRepository) {

    val favouriteCountFlow: Flow<Int> = repository.favouriteCountFlow
}