package com.example.searchworkapp.feature.auth.signIn

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.searchworkapp.base.ext.isEmail
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class SignInScreenModel : ScreenModel, KoinComponent {
    private fun setEvent(newEvent: SignInEvent) {
        screenModelScope.launch {
            _event.send(newEvent)
        }
    }

    private val _state = MutableStateFlow(SignInState.Default)
    val state = _state.asStateFlow()

    private val _event = Channel<SignInEvent>(Channel.BUFFERED)
    val event = _event.receiveAsFlow()

    fun changeEmail(value: String) {
        _state.value = _state.value.copy(email = value, isError = false)
    }

    fun signIn() {
        if (_state.value.email.isEmail()) {
            setEvent(SignInEvent.Next)
        } else {
            _state.value = _state.value.copy(isError = true)
        }
    }
}