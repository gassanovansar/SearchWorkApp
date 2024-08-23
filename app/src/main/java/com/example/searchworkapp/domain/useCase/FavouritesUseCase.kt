package com.example.searchworkapp.domain.useCase

import com.example.searchworkapp.domain.model.VacancyUI
import com.example.searchworkapp.domain.repository.FavouriteRepository

class FavouritesUseCase(private val repository: FavouriteRepository) {

    suspend operator fun invoke(): List<VacancyUI> {
        return repository.favourites()
    }
}