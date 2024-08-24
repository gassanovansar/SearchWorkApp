package com.example.auth.ui.sendSms

import cafe.adriel.voyager.core.model.screenModelScope
import com.example.auth.domain.AuthUseCase
import com.example.core.base.BaseScreenModel
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class SendSmsScreenModel : BaseScreenModel<SendSmsState, Any>(SendSmsState.Default) {
    private val authUseCase: AuthUseCase by inject()

    fun changeOtp(value: String) {
        setState { state.value.copy(otp = value) }
    }

    fun changeIsAuth() {
        launchOperation(operation = {
            authUseCase()
        })
    }
}