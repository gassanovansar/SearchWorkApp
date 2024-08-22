package com.example.searchworkapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import com.example.searchworkapp.base.RootNavigator
import com.example.searchworkapp.feature.auth.sendSms.SendSmsScreen
import com.example.searchworkapp.feature.search.SearchScreen
import com.example.searchworkapp.feature.splash.SplashScreen
import com.example.searchworkapp.uikit.theme.AppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun App() {
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            BottomSheetNavigator(
                sheetShape = RoundedCornerShape(
                    topStartPercent = 8,
                    topEndPercent = 8
                )
            ) {
//                Box(
//                    modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)
//                ) {
                Navigator(SearchScreen()) {
                    CompositionLocalProvider(
                        RootNavigator provides it,
                    ) {
                        CurrentScreen()
                    }
                }
//                }

            }
        }
    }
}