package com.example.auth.domain

import com.example.corekt.Either
import com.example.corekt.Failure

interface AuthRepository {
    suspend fun auth(): Either<Failure, Unit>
}