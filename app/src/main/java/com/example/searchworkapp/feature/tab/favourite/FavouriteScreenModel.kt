package com.example.searchworkapp.feature.tab.favourite

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FavouriteScreenModel : ScreenModel,KoinComponent {

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _state = MutableStateFlow(FavouriteState.Default)
    val state = _state.asStateFlow()


}