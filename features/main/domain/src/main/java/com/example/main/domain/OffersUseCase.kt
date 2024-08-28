package com.example.main.domain

import com.example.corekt.BaseUseCase
import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.models.domain.OfferUI
import kotlinx.coroutines.CoroutineScope


class OffersUseCase(private val offersRepository: MainRepository) :
    BaseUseCase<OffersUseCase.Params, List<OfferUI>>() {
    class Params

    override suspend fun execute(
        params: Params,
        scope: CoroutineScope
    ): Either<Failure, List<OfferUI>> {
        return offersRepository.offers()
    }
}