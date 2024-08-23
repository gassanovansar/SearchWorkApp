package com.example.searchworkapp.feature.auth.signIn

data class SignInState(val email: String) {

    val isValid = email.isNotBlank()

    companion object {
        val Default = SignInState(email = "")
    }
}