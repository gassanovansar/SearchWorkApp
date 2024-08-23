package com.example.main.domain

import com.example.models.OfferUI
import com.example.models.VacancyUI

interface MainRepository {

    suspend fun offers(): List<OfferUI>
    suspend fun vacancies(search: String): List<VacancyUI>
}