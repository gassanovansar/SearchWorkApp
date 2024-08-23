package com.example.detail.domain

import com.example.models.domain.VacancyUI


interface DetailRepository {
    suspend fun vacancy(id: String): VacancyUI
}