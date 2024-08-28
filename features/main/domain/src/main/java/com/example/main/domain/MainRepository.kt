package com.example.main.domain

import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.models.domain.OfferUI
import com.example.models.domain.VacancyUI


interface MainRepository {

    suspend fun offers(): Either<Failure, List<OfferUI>>
    suspend fun vacancies(search: String): Either<Failure, List<VacancyUI>>
}