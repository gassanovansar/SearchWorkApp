package com.example.auth.ui.sendSms

import com.example.auth.domain.AuthUseCase
import com.example.core.base.BaseScreenModel
import org.koin.core.component.inject

class SendSmsScreenModel : BaseScreenModel<SendSmsState, Any>(SendSmsState.Default) {
    private val authUseCase: AuthUseCase by inject()

    fun changeOtp(value: String) {
        setState { state.value.copy(otp = value) }
    }

    fun changeIsAuth() {
        launchOperation(operation = { scope ->
            authUseCase(scope, AuthUseCase.Params())
        })
    }
}