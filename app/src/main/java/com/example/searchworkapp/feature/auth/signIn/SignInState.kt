package com.example.searchworkapp.feature.auth.signIn

import com.example.searchworkapp.base.ext.isEmail

data class SignInState(val email: String, val isError: Boolean) {

    val isValid = email.isNotBlank()

    companion object {
        val Default = SignInState(email = "", isError = false)
    }
}