package com.example.searchworkapp.domain.useCase

import com.example.searchworkapp.domain.model.VacancyUI
import com.example.searchworkapp.domain.repository.VacanciesRepository

class VacanciesUseCase(private val repository: VacanciesRepository) {

    suspend operator fun invoke(search: String = "", count: Int? = null): List<VacancyUI> {
        return repository.vacancies(search, count)
    }
}
