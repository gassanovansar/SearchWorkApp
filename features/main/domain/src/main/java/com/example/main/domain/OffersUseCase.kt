package com.example.main.domain

import com.example.models.domain.OfferUI


class OffersUseCase(private val offersRepository: MainRepository) {
    suspend operator fun invoke(): List<OfferUI> {
        return offersRepository.offers()
    }
}