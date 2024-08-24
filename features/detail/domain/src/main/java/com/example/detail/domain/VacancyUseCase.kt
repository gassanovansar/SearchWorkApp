package com.example.detail.domain

import com.example.corekt.BaseUseCase
import com.example.models.domain.VacancyUI


class VacancyUseCase(private val repository: DetailRepository) :
    BaseUseCase<VacancyUseCase.Params, VacancyUI>() {

    class Params(val id: String)

    override suspend fun execute(params: Params): VacancyUI {
        return repository.vacancy(params.id)
    }
}
