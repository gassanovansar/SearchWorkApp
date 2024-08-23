package com.example.searchworkapp.di

import com.example.managers.SessionManager
import com.example.managers.SessionManagerImpl
import com.example.source.LocalSource
import org.koin.dsl.module

val sourceModule = module {
    single<LocalSource> { LocalSource(get()) }
    single<SessionManager> { SessionManagerImpl() }
}