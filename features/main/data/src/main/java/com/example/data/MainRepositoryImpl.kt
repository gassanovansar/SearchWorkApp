package com.example.data

import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.corekt.apiCall
import com.example.source.LocalSource
import com.example.models.mappers.toUI
import com.example.main.domain.MainRepository
import com.example.models.domain.OfferUI
import com.example.models.domain.VacancyUI

class MainRepositoryImpl(private val source: LocalSource) : MainRepository {
    override suspend fun offers(): Either<Failure, List<OfferUI>> {
        return apiCall(call = {
            source.loadOffers()
        }, mapResponse = {
            it.map { it.toUI() }
        })
    }

    override suspend fun vacancies(search: String): Either<Failure, List<VacancyUI>> {
        return apiCall(call = {
            source.loadVacancies(search)
        }, mapResponse = {
            it.map { it.toUI() }
        })
    }
}