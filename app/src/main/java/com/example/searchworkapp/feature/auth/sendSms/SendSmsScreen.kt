package com.example.searchworkapp.feature.auth.sendSms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.searchworkapp.feature.tab.TabScreen
import com.example.searchworkapp.uikit.designe.button.PrimaryButton
import com.example.searchworkapp.uikit.designe.button.Size
import com.example.searchworkapp.uikit.designe.otpTextFiled.OtpTextField
import com.example.searchworkapp.uikit.screens.PageContainer
import com.example.searchworkapp.uikit.theme.AppTheme

class SendSmsScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = rememberScreenModel { SendSmsScreenModel() }
        val state by viewModel.state.collectAsState()
        PageContainer(content = {
            Column {
                Spacer(modifier = Modifier.size(130.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "Отправили код на example@mail.ru",
                    style = AppTheme.typography.semiBold.copy(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        color = AppTheme.colors.white,
                    )
                )
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 16.dp),
                    text = "Напишите его, чтобы подтвердить, что это вы, а не кто-то другой входит в личный кабинет",
                    style = AppTheme.typography.medium.copy(
                        fontSize = 16.sp,
                        lineHeight = 19.2.sp,
                        color = AppTheme.colors.white,
                    )
                )

                OtpTextField(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 16.dp),
                    otpText = state.otp
                ) { value, _ ->
                    viewModel.changeOtp(value)
                }

                PrimaryButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .padding(horizontal = 16.dp),
                    size = Size.XXL,
                    enabled = state.isValid,
                    text = "Продолжить",
                ) {
                    navigator.push(TabScreen())
                }
            }
        })
    }
}