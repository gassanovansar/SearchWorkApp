package com.example.auth.domain

class AuthUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke() {
        authRepository.auth()
    }
}