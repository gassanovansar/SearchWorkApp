package com.example.searchworkapp.feature.search

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.searchworkapp.base.ext.debounce
import com.example.searchworkapp.domain.useCase.VacanciesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SearchScreenModel : ScreenModel, KoinComponent {

    private val vacanciesUseCase: VacanciesUseCase by inject()

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

}