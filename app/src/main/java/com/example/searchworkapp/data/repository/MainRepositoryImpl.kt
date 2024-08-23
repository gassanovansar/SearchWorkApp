package com.example.searchworkapp.data.repository

import com.example.models.OfferUI
import com.example.searchworkapp.data.source.LocalSource
import com.example.searchworkapp.data.mapper.toUI
import com.example.models.VacancyUI
import com.example.main.domain.MainRepository

class MainRepositoryImpl(private val source: LocalSource) : MainRepository {

    override suspend fun offers(): List<OfferUI> {
        return source.loadOffers().map { it.toUI() }
    }

    override suspend fun vacancies(search: String): List<VacancyUI> {
        return source.loadVacancies(search).map { it.toUI() }
    }
}