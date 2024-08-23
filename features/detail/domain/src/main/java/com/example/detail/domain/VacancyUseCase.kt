package com.example.detail.domain

import com.example.models.VacancyUI

class VacancyUseCase(private val repository: DetailRepository) {

    suspend operator fun invoke(id: String): VacancyUI {
        return repository.vacancy(id)
    }
}
