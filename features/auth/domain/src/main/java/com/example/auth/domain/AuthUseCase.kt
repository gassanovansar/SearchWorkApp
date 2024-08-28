package com.example.auth.domain

import com.example.corekt.BaseUseCase
import com.example.corekt.Either
import com.example.corekt.Failure
import kotlinx.coroutines.CoroutineScope

class AuthUseCase(private val authRepository: AuthRepository) :
    BaseUseCase<AuthUseCase.Params, Unit>() {
    class Params()

    override suspend fun execute(
        params: Params,
        scope: CoroutineScope
    ): Either<Failure, Unit> {
        return authRepository.auth()
    }
}