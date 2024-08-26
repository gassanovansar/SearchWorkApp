package com.example.auth.data

import com.example.auth.domain.AuthRepository
import com.example.managers.SessionManager

class AuthRepositoryImpl(private val sessionManager: SessionManager) : AuthRepository {
    override suspend fun auth() {
        sessionManager.setAuth()
    }
}