package com.example.source

import android.content.Context
import com.example.models.data.Data
import com.example.source.ChangeFavourites.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

private enum class ChangeFavourites(val boolean: Boolean) {
    DELETE(false), ADD(true)
}

class LocalSource(private val context: Context) {

    private val jsonSerializer = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }
    private var data: Data? = null

    private val favorites: MutableStateFlow<List<String>> =
        MutableStateFlow(loadSource().vacancies.filter { it.isFavorite == true }
            .map { it.id.orEmpty() })

    private fun loadSource(): Data {
        return if (data == null) {
            val json = context.assets.open("data.json").bufferedReader().use { it.readText() }
            jsonSerializer.decodeFromString<Data>(json).also { data = it }
        } else {
            data!!
        }
    }

    fun loadOffers() = loadSource().offers

    fun loadVacancies(search: String) = if (search.isNotBlank()) loadSource().vacancies.filter {
        it.title?.contains(search, true) ?: false
    } else loadSource().vacancies

    val favouriteCountFlow: Flow<Int> = favorites.map { it.size }

    fun loadVacancy(id: String) = loadSource().vacancies.find { it.id == id }


    fun loadFavourites() = loadSource().vacancies.filter { it.isFavorite == true }


    fun addFavourites(id: String) {
        if (favorites.value.find { it == id } == null) {
            favorites.value += listOf(id)
        }
        updateFavourite(id, ADD)
    }

    fun deleteFavourites(id: String) {
        if (favorites.value.find { it == id } != null) {
            favorites.value = favorites.value.filter { it != id }
        }
        updateFavourite(id, DELETE)
    }


    private fun updateFavourite(id: String, change: ChangeFavourites) {
        data = data?.copy(
            vacancies = data?.vacancies?.map {
                if (it.id == id) it.copy(
                    isFavorite = change.boolean
                ) else it
            }.orEmpty()
        )
    }
}


