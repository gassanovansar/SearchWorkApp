package com.example.searchworkapp.feature.auth.signIn

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignInScreenModel : ScreenModel {

    private val _state = MutableStateFlow(SignInState.Default)
    val state = _state.asStateFlow()

    fun changeEmail(value: String) {
        _state.value = _state.value.copy(email = value)
    }
}