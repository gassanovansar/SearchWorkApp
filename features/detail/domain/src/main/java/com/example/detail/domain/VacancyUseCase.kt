package com.example.detail.domain

import com.example.corekt.BaseUseCase
import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.models.domain.VacancyUI
import kotlinx.coroutines.CoroutineScope


class VacancyUseCase(private val repository: DetailRepository) :
    BaseUseCase<VacancyUseCase.Params, VacancyUI>() {

    class Params(val id: String)

    override suspend fun execute(
        params: Params,
        scope: CoroutineScope
    ): Either<Failure, VacancyUI> {
        return repository.vacancy(params.id)
    }
}
