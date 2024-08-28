package com.example.favourite.domain

import com.example.corekt.BaseUseCase
import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.models.domain.VacancyUI
import kotlinx.coroutines.CoroutineScope


class FavouritesUseCase(private val repository: FavouriteRepository) :
    BaseUseCase<FavouritesUseCase.Params, List<VacancyUI>>() {

    class Params()

    override suspend fun execute(
        params: Params,
        scope: CoroutineScope
    ): Either<Failure, List<VacancyUI>> {
        return repository.favourites()
    }
}