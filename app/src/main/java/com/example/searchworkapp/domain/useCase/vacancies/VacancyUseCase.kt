package com.example.searchworkapp.domain.useCase.vacancies

import com.example.searchworkapp.domain.model.VacancyUI
import com.example.searchworkapp.domain.repository.VacanciesRepository

class VacancyUseCase(private val repository: VacanciesRepository) {

    suspend operator fun invoke(id: String): VacancyUI {
        return repository.vacancy(id)
    }
}
