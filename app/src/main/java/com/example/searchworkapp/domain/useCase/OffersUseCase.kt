package com.example.searchworkapp.domain.useCase

import com.example.searchworkapp.domain.model.OfferUI
import com.example.searchworkapp.domain.repository.OffersRepository

class OffersUseCase(private val offersRepository: OffersRepository) {
    suspend operator fun invoke(): List<OfferUI> {
        return offersRepository.offers()
    }
}