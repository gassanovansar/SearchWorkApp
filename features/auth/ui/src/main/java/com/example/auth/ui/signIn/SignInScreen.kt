package com.example.auth.ui.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.auth.ui.R
import com.example.core.ext.clickableRound
import com.example.auth.ui.sendSms.SendSmsScreen
import com.example.uikit.designe.appCard.AppCard
import com.example.uikit.designe.appTextFiled.AppTextField
import com.example.uikit.designe.button.ButtonColor
import com.example.uikit.designe.button.PrimaryButton
import com.example.uikit.designe.button.Round
import com.example.uikit.designe.button.Size
import com.example.uikit.designe.toolBar.Toolbar
import com.example.uikit.screens.PageContainer
import com.example.uikit.theme.AppTheme
import kotlinx.coroutines.flow.collectLatest

class SignInScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = rememberScreenModel { SignInScreenModel() }
        val state by viewModel.state.collectAsState()
        LaunchedEffect(viewModel) {
            viewModel.event.collectLatest {
                when (it) {
                    SignInEvent.Next -> {
                        navigator.push(SendSmsScreen(state.email))
                    }
                }
            }
        }
        PageContainer(header = {
            Toolbar(startTitle = stringResource(id = R.string.login_your_personal_account))
        }, content = {
            Column(modifier = Modifier.align(Alignment.Center)) {
                AppCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {

                    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)) {
                        Text(
                            text = stringResource(id = R.string.job_search),
                            style = AppTheme.typography.medium.copy(
                                fontSize = 16.sp,
                                lineHeight = 19.2.sp,
                                color = AppTheme.colors.white,
                            )
                        )

                        AppTextField(
                            value = state.email,
                            error = state.isError,
                            hint = stringResource(id = R.string.email),
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
                                text = stringResource(id = R.string.continue_),
                            ) {
                                viewModel.signIn()
                            }
                            PrimaryButton(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.4f),
                                text = stringResource(id = R.string.login_with_password),
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
                            text = stringResource(id = R.string.search_for_employees),
                            style = AppTheme.typography.medium.copy(
                                fontSize = 16.sp,
                                lineHeight = 19.2.sp,
                                color = AppTheme.colors.white
                            )
                        )

                        Text(
                            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                            text = stringResource(id = R.string.posting_vacancies_and_access_to_the_resume_database),
                            style = AppTheme.typography.regular.copy(
                                fontSize = 14.sp,
                                lineHeight = 18.2.sp,
                                color = AppTheme.colors.white,
                                textAlign = TextAlign.Center,
                            )
                        )

                        PrimaryButton(
                            stringResource(id = R.string.i_m_looking_for_employees),
                            modifier = Modifier.fillMaxWidth(),
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