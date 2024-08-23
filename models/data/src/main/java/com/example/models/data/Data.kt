package com.example.models.data

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val offers: List<OfferResponse>,
    val vacancies: List<VacanciesResponse>
)
