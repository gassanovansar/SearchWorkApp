package com.example.detail.domain

import com.example.models.VacancyUI

interface DetailRepository {
    suspend fun vacancy(id: String): VacancyUI
}