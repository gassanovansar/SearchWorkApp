package com.example.searchworkapp.feature.auth.signIn

sealed class SignInEvent {

    object Next : SignInEvent()
}