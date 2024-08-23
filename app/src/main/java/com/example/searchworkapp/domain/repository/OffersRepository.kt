package com.example.searchworkapp.domain.repository

import com.example.searchworkapp.domain.model.OfferUI

interface OffersRepository {
    suspend fun offers(): List<OfferUI>
}