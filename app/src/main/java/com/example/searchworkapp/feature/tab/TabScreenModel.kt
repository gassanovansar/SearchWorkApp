package com.example.searchworkapp.feature.tab

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.favourite.domain.FavouriteCountFlowUseCase
import com.example.managers.SessionManager
import com.example.searchworkapp.di.KoinInjector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TabScreenModel : ScreenModel, KoinComponent {
    private val favouriteCountFlowUseCase: FavouriteCountFlowUseCase by inject()
    private val sessionManager: SessionManager by inject()

    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow()

    fun favouriteCount() {
        screenModelScope.launch {
            sessionManager.isAuth.collect {
                if (it) {
                    favouriteCountFlowUseCase.favouriteCountFlow.collect {
                        _state.value = it
                    }
                }
            }
        }
    }
}