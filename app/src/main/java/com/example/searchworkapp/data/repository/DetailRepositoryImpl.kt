package com.example.searchworkapp.data.repository

import com.example.detail.domain.DetailRepository
import com.example.models.VacancyUI
import com.example.searchworkapp.data.mapper.toUI
import com.example.searchworkapp.data.source.LocalSource

class DetailRepositoryImpl(private val source: LocalSource) : DetailRepository {
    override suspend fun vacancy(id: String): VacancyUI {
        return source.loadVacancy(id)?.toUI() ?: VacancyUI.Default
    }
}