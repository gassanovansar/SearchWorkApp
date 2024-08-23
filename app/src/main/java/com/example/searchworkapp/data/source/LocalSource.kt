package com.example.searchworkapp.data.source

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class LocalSource(private val context: Context) {

    private val jsonSerializer = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }
    private val favorites: MutableStateFlow<List<String>> =
        MutableStateFlow(loadSource().vacancies.filter { it.isFavorite == true }
            .map { it.id.orEmpty() })

    private var temp: Temp? = null
    private fun loadSource(): Temp {
        return if (temp == null) {
            val json = context.assets.open("data.json").bufferedReader().use {
                it.readText()
            }
            jsonSerializer.decodeFromString<Temp>(json).also {
                temp = it
            }
        } else {
            temp!!
        }


    }

    fun loadOffers() = loadSource().offers

    fun loadVacancies(search: String): List<VacanciesResponse> {
        return if (search.isNotBlank()) loadSource().vacancies.filter {
            it.title?.contains(search, true) ?: false
        } else loadSource().vacancies
    }

    val favouriteCountFlow: Flow<Int> = favorites.map { it.size }

    fun loadFavourites() = loadSource().vacancies.filter { it.isFavorite == true }
    fun addFavourites(id: String) {
        if (favorites.value.find { it == id } == null) {
            favorites.value += listOf(id)
        }
        temp =
            temp?.copy(vacancies = temp?.vacancies?.map { if (it.id == id) it.copy(isFavorite = true) else it }
                .orEmpty())
    }

    fun deleteFavourites(id: String) {
        if (favorites.value.find { it == id } != null) {
            favorites.value = favorites.value.filter { it != id }
        }
        temp = temp?.copy(vacancies = temp?.vacancies?.map { if (it.id == id) it.copy(isFavorite = true) else it }
                .orEmpty())
    }


    fun loadVacancy(id: String) = loadSource().vacancies.find { it.id == id }


}


@Serializable
data class Temp(
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


