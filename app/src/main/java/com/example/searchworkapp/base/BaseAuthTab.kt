package com.example.searchworkapp.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.example.searchworkapp.data.sessionManager.SessionManager
import com.example.searchworkapp.di.KoinInjector
import com.example.auth.ui.signIn.SignInScreen

interface BaseAuthTab : Tab {

    @Composable
    override fun Content() {
        val sessionManager: SessionManager by KoinInjector.koinApp.koin.inject<SessionManager>()
        val isAuth by sessionManager.isAuth.collectAsState()
        if (isAuth){
            AuthContent()
        }else {
            Navigator(SignInScreen())
        }
//        Navigator(
//            if (isAuth) {
//                AuthContent()
//            } else {
//                SignInScreen()
//            }
//        ) {
//            Content()
//        }
    }

    @Composable
    fun AuthContent()


}