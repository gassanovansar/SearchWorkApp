package com.example.auth.data

import com.example.auth.domain.AuthRepository
import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.corekt.apiCall
import com.example.managers.SessionManager

class AuthRepositoryImpl(private val sessionManager: SessionManager) : AuthRepository {

    override suspend fun auth(): Either<Failure, Unit> {
        return apiCall(call = {
            sessionManager.setAuth()
        })
    }
}