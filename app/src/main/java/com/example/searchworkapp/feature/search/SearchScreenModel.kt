package com.example.searchworkapp.feature.search

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.searchworkapp.base.ext.debounce
import com.example.searchworkapp.domain.model.VacancyUI
import com.example.searchworkapp.domain.useCase.favourite.AddFavouritesUseCase
import com.example.searchworkapp.domain.useCase.favourite.DeleteFavouritesUseCase
import com.example.searchworkapp.domain.useCase.vacancies.VacanciesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SearchScreenModel : ScreenModel, KoinComponent {

    private val vacanciesUseCase: VacanciesUseCase by inject()
    private val addFavouritesUseCase: AddFavouritesUseCase by inject()
    private val deleteFavouritesUseCase: DeleteFavouritesUseCase by inject()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _state = MutableStateFlow(SearchState.Default)
    val state = _state.asStateFlow()


    fun loadVacancies(search: String = "") {
        screenModelScope.launch {
            _state.value =
                _state.value.copy(vacancy = vacanciesUseCase(search))
        }
    }

    fun changeSearch(value: String) {
        _state.value = _state.value.copy(search = value)
        debounceSearch(value)

    }

    private val debounceSearch = debounce<String?>(screenModelScope) {
        loadVacancies(it.orEmpty())
    }

    fun isFavourites(item: VacancyUI) {
        screenModelScope.launch {
            if (item.isFavorite) deleteFavouritesUseCase(item.id)
            else addFavouritesUseCase(item.id)
            _state.value = _state.value.copy(vacancy = _state.value.vacancy.map {
                if (it.id == item.id) it.copy(isFavorite = !it.isFavorite) else it
            })
        }
    }

}