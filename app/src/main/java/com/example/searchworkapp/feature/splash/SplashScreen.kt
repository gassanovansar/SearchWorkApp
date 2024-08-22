package com.example.searchworkapp.feature.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.searchworkapp.feature.auth.signIn.SignInScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class SplashScreen : Screen {


    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        LaunchedEffect(Unit) {
            launch {
                delay(1000)
                navigator.replaceAll(SignInScreen())
            }

        }
    }
}