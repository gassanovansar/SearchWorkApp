package com.example.searchworkapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val offers: List<OfferResponse>,
    val vacancies: List<VacanciesResponse>
)
