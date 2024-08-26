package com.example.data

import com.example.source.LocalSource
import com.example.models.mappers.toUI
import com.example.main.domain.MainRepository
import com.example.models.domain.OfferUI
import com.example.models.domain.VacancyUI

class MainRepositoryImpl(private val source: LocalSource) : MainRepository {

    override suspend fun offers(): List<OfferUI> {
        return source.loadOffers().map { it.toUI() }
    }

    override suspend fun vacancies(search: String): List<VacancyUI> {
        return source.loadVacancies(search).map { it.toUI() }
    }
}