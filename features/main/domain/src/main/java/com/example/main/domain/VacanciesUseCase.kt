package com.example.main.domain

import com.example.models.domain.VacancyUI


class VacanciesUseCase(private val repository: MainRepository) {

    suspend operator fun invoke(search: String = ""): List<VacancyUI> {
        return repository.vacancies(search)
    }
}
