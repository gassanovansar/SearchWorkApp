package com.example.main.domain

import com.example.models.domain.OfferUI
import com.example.models.domain.VacancyUI


interface MainRepository {

    suspend fun offers(): List<OfferUI>
    suspend fun vacancies(search: String): List<VacancyUI>
}