package com.example.searchworkapp.domain.useCase

import com.example.searchworkapp.domain.model.VacancyUI
import com.example.searchworkapp.domain.repository.VacanciesRepository

class VacanciesUseCase(private val repository: VacanciesRepository) {

    suspend operator fun invoke(search: String = ""): List<VacancyUI> {
        return repository.vacancies(search)
    }
}
