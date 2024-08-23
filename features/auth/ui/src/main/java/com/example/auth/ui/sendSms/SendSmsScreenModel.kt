package com.example.auth.ui.sendSms

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.auth.domain.AuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SendSmsScreenModel : ScreenModel, KoinComponent {
    private val authUseCase: AuthUseCase by inject()

    private val _state = MutableStateFlow(SendSmsState.Default)
    val state = _state.asStateFlow()

    fun changeOtp(value: String) {
        _state.value = _state.value.copy(otp = value)
    }

    fun changeIsAuth() {
        screenModelScope.launch {
            authUseCase()
        }
    }
}