package com.example.auth.data

import com.example.auth.domain.AuthRepository
import com.example.corekt.Either
import com.example.corekt.Failure
import com.example.corekt.apiCall
import com.example.corekt.doOnFailure
import com.example.corekt.doOnSuccess
import com.example.managers.SessionManager
import retrofit2.http.GET

class AuthRepositoryImpl(private val sessionManager: SessionManager, val api: Api) :
    AuthRepository {

    override suspend fun auth(): Either<Failure, Unit> {
        return apiCall(call = {
            api.sso()
        }).doOnSuccess {
            println()
        }.doOnFailure {
            println()
        }
    }
}

interface Api {

    @GET("v1/guest/country-list")
    suspend fun sso()
}