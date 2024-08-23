package com.example.searchworkapp.data.source

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class LocalSource(private val context: Context) {

    private val jsonSerializer = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    private fun loadSource(): Temp {
        val json = context.assets.open("data.json").bufferedReader().use {
            it.readText()
        }
        return jsonSerializer.decodeFromString<Temp>(json)
    }

    fun loadOffers() = loadSource().offers

    fun loadVacancies(search: String): List<VacanciesResponse> {
        return if (search.isNotBlank()) loadSource().vacancies.filter {
            it.title?.contains(search, true) ?: false
        } else loadSource().vacancies
    }

    val favouriteCountFlow: Flow<Int> =
        flowOf(loadSource().vacancies.filter { it.isFavorite == true }.size)

    fun loadFavourites() = loadSource().vacancies.filter { it.isFavorite == true }


    fun loadVacancy(id: String) = loadSource().vacancies.find { it.id == id }


}


@Serializable
class Temp(
    val offers: List<OfferResponse>,
    val vacancies: List<VacanciesResponse>
)

@Serializable
class OfferResponse(
    val id: String?,
    val title: String?,
    val button: OfferButtonResponse?,
    val link: String?
)

@Serializable
class OfferButtonResponse(val text: String?)

@Serializable
class VacanciesResponse(
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


