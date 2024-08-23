package com.example.ui

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.favourite.domain.AddFavouritesUseCase
import com.example.favourite.domain.DeleteFavouritesUseCase
import com.example.main.domain.OffersUseCase
import com.example.main.domain.VacanciesUseCase
import com.example.models.VacancyUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainScreenModel : ScreenModel, KoinComponent {

    private val offersUseCase: OffersUseCase by inject()
    private val vacanciesUseCase: VacanciesUseCase by inject()
    private val addFavouritesUseCase: AddFavouritesUseCase by inject()
    private val deleteFavouritesUseCase: DeleteFavouritesUseCase by inject()

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
            _state.value = _state.value.copy(vacancy = vacanciesUseCase())
        }
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