package com.example.detail.data

import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.corekt.apiCall
import com.example.detail.domain.DetailRepository
import com.example.models.domain.VacancyUI
import com.example.models.mappers.toUI
import com.example.source.LocalSource

class DetailRepositoryImpl(private val source: LocalSource) :
    DetailRepository {

    override suspend fun vacancy(id: String): Either<Failure, VacancyUI> {
        return apiCall(
            call = {
                source.loadVacancy(id)
            }, mapResponse = {
                it?.toUI() ?: VacancyUI.Default
            }
        )
    }
}