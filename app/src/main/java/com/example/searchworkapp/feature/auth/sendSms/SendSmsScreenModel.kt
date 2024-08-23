package com.example.searchworkapp.feature.auth.sendSms

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SendSmsScreenModel : ScreenModel {

    private val _state = MutableStateFlow(SendSmsState.Default)
    val state = _state.asStateFlow()

    fun changeOtp(value: String) {
        _state.value = _state.value.copy(otp = value)
    }
}