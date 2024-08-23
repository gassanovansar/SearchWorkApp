package com.example.searchworkapp.feature.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.searchworkapp.feature.auth.signIn.SignInScreen
import com.example.uikit.screens.PageContainer
import com.example.uikit.theme.AppTheme
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

        PageContainer(content = {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "SearchWorkApp",
                    style = AppTheme.typography.semiBold.copy(
                        fontSize = 40.sp,
                        lineHeight = 24.sp,
                        color = AppTheme.colors.white,
                    )
                )
            }

        })
    }
}