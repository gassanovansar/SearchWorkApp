package com.example.searchworkapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.searchworkapp.di.KoinInjector
import com.example.searchworkapp.domain.useCase.FavouritesUseCase
import kotlinx.coroutines.coroutineScope
import org.koin.android.ext.koin.androidContext

object FavouritesCount {
    var count: Int = 0
}

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        KoinInjector.koinApp.androidContext(this)
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}
