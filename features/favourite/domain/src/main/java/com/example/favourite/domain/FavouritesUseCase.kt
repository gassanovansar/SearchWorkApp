package com.example.favourite.domain

import com.example.corekt.BaseUseCase
import com.example.models.domain.VacancyUI


class FavouritesUseCase(private val repository: FavouriteRepository) :
    BaseUseCase<FavouritesUseCase.Params, List<VacancyUI>>() {

    class Params()

    override suspend fun execute(params: Params): List<VacancyUI> {
        return repository.favourites()
    }
}