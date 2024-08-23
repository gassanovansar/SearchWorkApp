package com.example.auth.ui.signIn

sealed class SignInEvent {

    object Next : SignInEvent()
}