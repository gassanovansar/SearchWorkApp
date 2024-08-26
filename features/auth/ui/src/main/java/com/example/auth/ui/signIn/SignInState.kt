package com.example.auth.ui.signIn

data class SignInState(val email: String, val isError: Boolean) {

    val isValid = email.isNotBlank()

    companion object {
        val Default = SignInState(email = "", isError = false)
    }
}