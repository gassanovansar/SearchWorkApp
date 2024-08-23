package com.example.searchworkapp.data.sessionManager

import kotlinx.coroutines.flow.MutableStateFlow

interface SessionManager {

    var isAuth: MutableStateFlow<Boolean>
}


class SessionManagerImpl() : SessionManager {

    override var isAuth: MutableStateFlow<Boolean> = MutableStateFlow(false)


}