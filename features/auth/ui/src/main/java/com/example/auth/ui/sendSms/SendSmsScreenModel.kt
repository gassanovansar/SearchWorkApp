package com.example.auth.ui.sendSms

import cafe.adriel.voyager.core.model.ScreenModel
//import com.example.searchworkapp.data.sessionManager.SessionManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SendSmsScreenModel : ScreenModel, KoinComponent {
//    private val sessionManager: SessionManager by inject()

    private val _state = MutableStateFlow(SendSmsState.Default)
    val state = _state.asStateFlow()

    fun changeOtp(value: String) {
        _state.value = _state.value.copy(otp = value)
    }

    fun changeIsAuth() {
//        sessionManager.isAuth.value = true
    }
}