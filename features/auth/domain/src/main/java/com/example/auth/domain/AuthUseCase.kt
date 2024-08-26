package com.example.auth.domain

import com.example.corekt.BaseUseCase

class AuthUseCase(private val authRepository: AuthRepository) : BaseUseCase<AuthUseCase.Params, Unit>() {
    class Params()

    override suspend fun execute(params: Params) {
        return authRepository.auth()
    }
}