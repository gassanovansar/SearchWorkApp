package com.example.searchworkapp.domain.useCase

import com.example.searchworkapp.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow

class FavouriteCountFlowUseCase(private val repository: FavouriteRepository) {

    val favouriteCountFlow: Flow<Int> = repository.favouriteCountFlow
}