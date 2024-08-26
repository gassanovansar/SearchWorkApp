package com.example.main.domain

import com.example.corekt.BaseUseCase
import com.example.models.domain.VacancyUI


class VacanciesUseCase(private val repository: MainRepository) : BaseUseCase<VacanciesUseCase.Params, List<VacancyUI>>() {
    class Params(val search: String = "")

    override suspend fun execute(params: Params): List<VacancyUI> {
        return repository.vacancies(params.search)
    }

}
