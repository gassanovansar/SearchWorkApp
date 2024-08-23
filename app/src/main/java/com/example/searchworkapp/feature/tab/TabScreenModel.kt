package com.example.searchworkapp.feature.tab

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.searchworkapp.domain.useCase.FavouriteCountFlowUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TabScreenModel : ScreenModel, KoinComponent {
    private val favouriteCountFlowUseCase: FavouriteCountFlowUseCase by inject()

    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow()

    fun favouriteCount() {
        screenModelScope.launch {
            favouriteCountFlowUseCase.favouriteCountFlow.collect {
                _state.value = it
            }
        }

    }


}