package com.example.searchworkapp.feature.sendRequest

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SendRequestBottomScreenModel : ScreenModel {

    private val _state = MutableStateFlow(SendRequestBottomState.Default)
    val state = _state.asStateFlow()

    fun changeQuestion(value: String) {
        _state.value = state.value.copy(question = value)
    }

}