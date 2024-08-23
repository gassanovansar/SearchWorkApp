package com.example.searchworkapp.feature.tab.search

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.searchworkapp.domain.useCase.OffersUseCase
import com.example.searchworkapp.domain.useCase.VacanciesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainScreenModel : ScreenModel, KoinComponent {

    private val offersUseCase: OffersUseCase by inject()
    private val vacanciesUseCase: VacanciesUseCase by inject()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _state = MutableStateFlow(MainState.Default)
    val state = _state.asStateFlow()

    fun loadOffers() {
        screenModelScope.launch {
            _state.value = _state.value.copy(offers = offersUseCase())
        }
    }

    fun loadVacancies() {
        screenModelScope.launch {
            _state.value = _state.value.copy(vacancy = vacanciesUseCase(count = 10))
        }
    }

}