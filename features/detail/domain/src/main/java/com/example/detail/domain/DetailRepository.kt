package com.example.detail.domain

import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.models.domain.VacancyUI


interface DetailRepository {
    suspend fun vacancy(id: String): Either<Failure, VacancyUI>
}