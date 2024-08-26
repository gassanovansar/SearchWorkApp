package com.example.searchworkapp.feature.tab

import cafe.adriel.voyager.core.model.screenModelScope
import com.example.core.base.BaseScreenModel
import com.example.favourite.domain.FavouriteCountFlowUseCase
import com.example.managers.SessionManager
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class TabScreenModel : BaseScreenModel<Int, Any>(0) {

    private val favouriteCountFlowUseCase: FavouriteCountFlowUseCase by inject()
    private val sessionManager: SessionManager by inject()

    fun favouriteCount() {
        screenModelScope.launch {
            sessionManager.isAuth.collect {
                if (it) {
                    favouriteCountFlowUseCase().collect {
                        setState { it }
                    }
                }
            }
        }
    }
}