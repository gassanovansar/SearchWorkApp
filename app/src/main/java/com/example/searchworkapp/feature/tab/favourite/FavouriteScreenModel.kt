package com.example.searchworkapp.feature.tab.favourite

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.searchworkapp.domain.useCase.FavouritesUseCase
import com.example.searchworkapp.domain.useCase.VacanciesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FavouriteScreenModel : ScreenModel, KoinComponent {

    private val favouritesUseCase: FavouritesUseCase by inject()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _state = MutableStateFlow(FavouriteState.Default)
    val state = _state.asStateFlow()

    fun loadFavourites() {
        screenModelScope.launch {
            _state.value =
                _state.value.copy(favourites = favouritesUseCase())
        }
    }

}