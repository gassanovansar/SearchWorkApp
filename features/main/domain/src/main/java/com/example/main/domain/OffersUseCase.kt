package com.example.main.domain

import com.example.corekt.BaseUseCase
import com.example.models.domain.OfferUI


class OffersUseCase(private val offersRepository: MainRepository): BaseUseCase<OffersUseCase.Params,List<OfferUI>>() {
    class Params

    override suspend fun execute(params: Params): List<OfferUI> {
        return offersRepository.offers()
    }
}