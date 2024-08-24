package com.example.detail.ui.sendRequest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import com.example.core.ext.clickableRound
import com.example.detail.ui.R
import com.example.uikit.designe.appCard.AppCard
import com.example.uikit.designe.appTextFiled.DefaultTextFiled
import com.example.uikit.designe.button.ButtonColor
import com.example.uikit.designe.button.PrimaryButton
import com.example.uikit.screens.PageContainer
import com.example.uikit.theme.AppTheme

class SendRequestBottomScreen(private val question: String = "") : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { SendRequestBottomScreenModel() }
        val state by viewModel.state.collectAsState()
        val bottomSheetNavigator = LocalBottomSheetNavigator.current
        LaunchedEffect(viewModel) {
            viewModel.changeQuestion(question)
        }
        var isVisible by remember { mutableStateOf(question.isNotBlank()) }

        PageContainer(fill = false, content = {
            Column {

                CompanyInfoItem(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 24.dp)
                )
                Divider(
                    color = AppTheme.colors.gray2,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 26.dp)
                )
                AnimatedVisibility(visible = isVisible) {
                    DefaultTextFiled(
                        value = state.question,
                        hint = stringResource(id = R.string.your_cover_letter),
                        modifier = Modifier.padding(top = 16.dp),
                        minLines = 4
                    ) {}
                }
                AnimatedVisibility(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    visible = !isVisible
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 40.dp)
                            .clickableRound(2.dp) {
                                isVisible = true
                            },
                        text = stringResource(id = R.string.add_accompanying_text),
                        style = AppTheme.typography.semiBold.copy(
                            fontSize = 16.sp,
                            lineHeight = 20.8.sp,
                            color = AppTheme.colors.green,
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                PrimaryButton(
                    text = stringResource(id = R.string.reply),
                    backgroundColor = ButtonColor.GREEN,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = if (question.isNotBlank()) 11.dp else 20.dp, bottom = 32.dp)
                ) { bottomSheetNavigator.hide() }
            }

        })
    }


    @Composable
    private fun CompanyInfoItem(modifier: Modifier) {
        Row(modifier) {
            AppCard(shape = CircleShape, modifier = Modifier.size(48.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_company),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = stringResource(id = R.string.resume_for_response),
                    style = AppTheme.typography.regular.copy(
                        fontSize = 14.sp,
                        lineHeight = 16.8.sp,
                        color = AppTheme.colors.gray3,
                    )
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = "UI/UX дизайнер ",
                    style = AppTheme.typography.medium.copy(
                        fontSize = 16.sp,
                        lineHeight = 19.2.sp,
                        color = AppTheme.colors.white
                    )
                )
            }


        }
    }
}