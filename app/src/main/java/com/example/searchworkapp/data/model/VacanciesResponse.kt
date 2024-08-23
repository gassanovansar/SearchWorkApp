package com.example.searchworkapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class VacanciesResponse(
    val id: String?,
    val lookingNumber: Int?,
    val title: String?,
    val address: VacanciesAddressResponse?,
    val company: String?,
    val experience: VacanciesExperienceResponse?,
    val publishedDate: String?,
    val isFavorite: Boolean?,
    val salary: VacanciesSalaryResponse?,
    val schedules: List<String>?,
    val appliedNumber: Int?,
    val description: String?,
    val responsibilities: String?,
    val questions: List<String>?
)

@Serializable
class VacanciesAddressResponse(
    val town: String?,
    val street: String?,
    val house: String?
)

@Serializable
class VacanciesExperienceResponse(
    val previewText: String?,
    val text: String?,
)

@Serializable
class VacanciesSalaryResponse(
    val full: String?,
)