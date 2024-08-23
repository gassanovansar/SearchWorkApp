package com.example.searchworkapp.data.repository

import com.example.searchworkapp.data.source.LocalSource
import com.example.searchworkapp.domain.mapper.toUI
import com.example.searchworkapp.domain.model.VacancyUI
import com.example.searchworkapp.domain.repository.VacanciesRepository

class VacanciesRepositoryImpl(private val source: LocalSource) : VacanciesRepository {
    override suspend fun vacancies(search: String, count: Int?): List<VacancyUI> {
        return source.loadVacancies(search, count).map { it.toUI() }
    }

    override suspend fun vacancy(id: String): VacancyUI {
        return source.loadVacancy(id)?.toUI() ?: VacancyUI.Default
    }
}