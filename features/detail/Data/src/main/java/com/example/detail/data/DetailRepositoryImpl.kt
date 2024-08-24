package com.example.detail.data

import com.example.detail.domain.DetailRepository
import com.example.models.domain.VacancyUI
import com.example.models.mappers.toUI
import com.example.source.LocalSource

class DetailRepositoryImpl(private val source: LocalSource) : DetailRepository {

    override suspend fun vacancy(id: String) = source.loadVacancy(id)?.toUI() ?: VacancyUI.Default
}