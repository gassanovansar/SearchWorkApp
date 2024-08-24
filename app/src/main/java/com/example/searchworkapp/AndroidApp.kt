package com.example.searchworkapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.searchworkapp.di.KoinInjector
import org.koin.android.ext.koin.androidContext

class AndroidApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInjector.koinApp.androidContext(this)
    }
}

