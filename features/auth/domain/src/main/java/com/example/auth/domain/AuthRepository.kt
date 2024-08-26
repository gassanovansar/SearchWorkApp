package com.example.auth.domain

interface AuthRepository {
    suspend fun auth()
}