package com.example.searchworkapp.data.repository

import com.example.searchworkapp.data.source.LocalSource
import com.example.searchworkapp.domain.mapper.toUI
import com.example.searchworkapp.domain.model.OfferUI
import com.example.searchworkapp.domain.repository.OffersRepository

class OffersRepositoryImpl(private val source: LocalSource) : OffersRepository {
    override suspend fun offers(): List<OfferUI> {
        return source.loadOffers().map { it.toUI() }
    }
}