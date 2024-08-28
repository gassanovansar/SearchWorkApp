package com.example.detail.data

import com.example.models.data.VacanciesResponse

interface Api {

    suspend fun loadVacancy(id: String): VacanciesResponse?
}