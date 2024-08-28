package com.example.main.domain

import com.example.corekt.BaseUseCase
import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.models.domain.VacancyUI
import kotlinx.coroutines.CoroutineScope


class VacanciesUseCase(private val repository: MainRepository) :
    BaseUseCase<VacanciesUseCase.Params, List<VacancyUI>>() {
    class Params(val search: String = "")


    override suspend fun execute(
        params: Params,
        scope: CoroutineScope
    ): Either<Failure, List<VacancyUI>> {
        return repository.vacancies(params.search)
    }

}
