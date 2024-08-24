package com.example.auth.ui.signIn

import com.example.core.base.BaseScreenModel
import com.example.core.ext.isEmail

class SignInScreenModel : BaseScreenModel<SignInState, SignInEvent>(SignInState.Default) {


    fun changeEmail(value: String) {
        setState {
            state.value.copy(email = value, isError = false)
        }
    }

    fun signIn() {
        if (state.value.email.isEmail()) {
            setEvent(SignInEvent.Next)
        } else {
            setState {
                state.value.copy(isError = true)
            }
        }
    }
}