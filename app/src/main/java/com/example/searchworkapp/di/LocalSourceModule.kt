package com.example.searchworkapp.di

import com.example.searchworkapp.data.sessionManager.SessionManager
import com.example.searchworkapp.data.sessionManager.SessionManagerImpl
import com.example.searchworkapp.data.source.LocalSource
import org.koin.dsl.module

val sourceModule = module {
    single<LocalSource> { LocalSource(get()) }
    single<SessionManager> { SessionManagerImpl() }
}