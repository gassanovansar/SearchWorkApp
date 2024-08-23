package com.example.detail.ui.details

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.detail.domain.VacancyUseCase
import com.example.favourite.domain.AddFavouritesUseCase
import com.example.favourite.domain.DeleteFavouritesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DetailScreenModel : ScreenModel, KoinComponent {
    val vacancyUseCase: VacancyUseCase by inject()
    private val addFavouritesUseCase: AddFavouritesUseCase by inject()
    private val deleteFavouritesUseCase: DeleteFavouritesUseCase by inject()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _state = MutableStateFlow(DetailState.Default)
    val state = _state.asStateFlow()

    fun loadVacancy(id: String) {
        screenModelScope.launch {
            _state.value = _state.value.copy(vacancy = vacancyUseCase(id))
        }
    }

    fun isFavourites() {
        screenModelScope.launch {
            if (_state.value.vacancy.isFavorite) deleteFavouritesUseCase(_state.value.vacancy.id)
            else addFavouritesUseCase(_state.value.vacancy.id)
            _state.value = _state.value.copy(
                vacancy = _state.value.vacancy.copy(isFavorite = !_state.value.vacancy.isFavorite)
            )
        }
    }

}