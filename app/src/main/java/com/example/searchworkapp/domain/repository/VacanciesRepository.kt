package com.example.searchworkapp.domain.repository

import com.example.searchworkapp.domain.model.OfferUI
import com.example.searchworkapp.domain.model.VacancyUI

interface VacanciesRepository {
    suspend fun vacancies(search: String, count: Int?): List<VacancyUI>
    suspend fun vacancy(id: String): VacancyUI
}