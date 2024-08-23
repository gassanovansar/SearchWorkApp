package com.example.searchworkapp.feature.auth.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.searchworkapp.R
import com.example.searchworkapp.base.ext.clickableRound
import com.example.searchworkapp.feature.auth.sendSms.SendSmsScreen
import com.example.searchworkapp.uikit.designe.appCard.AppCard
import com.example.searchworkapp.uikit.designe.appTextFiled.AppTextField
import com.example.searchworkapp.uikit.designe.button.ButtonColor
import com.example.searchworkapp.uikit.designe.button.PrimaryButton
import com.example.searchworkapp.uikit.designe.button.Round
import com.example.searchworkapp.uikit.designe.button.Size
import com.example.searchworkapp.uikit.designe.toolBar.Toolbar
import com.example.searchworkapp.uikit.screens.PageContainer
import com.example.searchworkapp.uikit.theme.AppTheme

class SignInScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = rememberScreenModel { SignInScreenModel() }
        val state by viewModel.state.collectAsState()
        PageContainer(header = {
            Toolbar(startTitle = "Вход в личный кабинет")
        }, content = {
            Column(modifier = Modifier.align(Alignment.Center)) {
                AppCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {

                    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)) {
                        Text(
                            text = "Поиск работы",
                            style = AppTheme.typography.medium.copy(
                                fontSize = 16.sp,
                                lineHeight = 19.2.sp,
                                color = AppTheme.colors.white,
                            )
                        )

                        AppTextField(
                            value = state.email,
                            hint = "Электронная почта или телефон",
                            modifier = Modifier.padding(vertical = 16.dp),
                            right = if (state.isValid) {
                                {
                                    Image(
                                        modifier = Modifier.clickableRound(4.dp) {
                                            viewModel.changeEmail("")
                                        },
                                        painter = painterResource(id = R.drawable.ic_close),
                                        contentDescription = ""
                                    )
                                }
                            } else null,
                            left = {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_envelope),
                                    contentDescription = ""
                                )
                            }
                        ) {
                            viewModel.changeEmail(it)
                        }

                        Row {
                            PrimaryButton(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.6f)
                                    .padding(end = 16.dp),
                                enabled = state.isValid,
                                size = Size.XL,
                                text = "Продолжить",
                            ) {
                                navigator.push(SendSmsScreen())
                            }
                            PrimaryButton(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.4f),
                                text = "Войти с паролем",
                                backgroundColor = ButtonColor.TRANSPARENT,
                                size = Size.XL
                            ) {}
                        }
                    }


                }
                Spacer(modifier = Modifier.size(16.dp))
                AppCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)) {
                        Text(
                            text = "Поиск сотрудников",
                            style = AppTheme.typography.medium.copy(
                                fontSize = 16.sp,
                                lineHeight = 19.2.sp,
                                color = AppTheme.colors.white
                            )
                        )

                        Text(
                            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                            text = "Размещение вакансий и доступ к базе резюме",
                            style = AppTheme.typography.regular.copy(
                                fontSize = 14.sp,
                                lineHeight = 18.2.sp,
                                color = AppTheme.colors.white,
                                textAlign = TextAlign.Center,
                            )
                        )

                        PrimaryButton(
                            "Я ищу сотрудников", modifier = Modifier.fillMaxWidth(),
                            backgroundColor = ButtonColor.GREEN,
                            round = Round.CIRCLE,
                            size = Size.L
                        ) {

                        }
                    }
                }
            }
        }, footer = {
            Spacer(modifier = Modifier.size(100.dp))
        })
    }
}