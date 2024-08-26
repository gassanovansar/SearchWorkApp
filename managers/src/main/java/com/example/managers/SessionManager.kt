package com.example.managers

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface SessionManager {

    val isAuth: StateFlow<Boolean>

    fun setAuth()
}


class SessionManagerImpl : SessionManager {

    override val isAuth: MutableStateFlow<Boolean> = MutableStateFlow(false)

    override fun setAuth() {
        isAuth.value = true
    }


}