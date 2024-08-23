package com.example.favourite.domain

import com.example.models.VacancyUI


class FavouritesUseCase(private val repository: FavouriteRepository) {

    suspend operator fun invoke(): List<VacancyUI> {
        return repository.favourites()
    }
}