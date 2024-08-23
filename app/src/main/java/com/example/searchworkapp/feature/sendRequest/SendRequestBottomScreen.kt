package com.example.searchworkapp.feature.sendRequest

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.searchworkapp.R
import com.example.searchworkapp.base.ext.clickableRound
import com.example.searchworkapp.uikit.designe.appCard.AppCard
import com.example.searchworkapp.uikit.designe.appTextFiled.DefaultTextFiled
import com.example.searchworkapp.uikit.designe.button.ButtonColor
import com.example.searchworkapp.uikit.designe.button.PrimaryButton
import com.example.searchworkapp.uikit.screens.PageContainer
import com.example.searchworkapp.uikit.theme.AppTheme

class SendRequestBottomScreen(private val question: String = "") : Screen {
    @Composable
    override fun Content() {
        var _question by remember { mutableStateOf(question) }

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
                AnimatedVisibility(visible = _question.isNotBlank()) {
                    DefaultTextFiled(
                        value = "",
                        hint = "Ваше сопроводительное письмо",
                        modifier = Modifier.padding(top = 16.dp),
                        minLines = 4
                    ) {}
                }
                AnimatedVisibility(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    visible = _question.isBlank()
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 40.dp)
                            .clickableRound(2.dp) {
                                _question = "0"
                            },
                        text = "Добавить сопроводительное",
                        style = AppTheme.typography.semiBold.copy(
                            fontSize = 16.sp,
                            lineHeight = 20.8.sp,
                            color = AppTheme.colors.green,
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                PrimaryButton(
                    text = "Откликнуться",
                    backgroundColor = ButtonColor.GREEN,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = if (question.isNotBlank()) 11.dp else 20.dp, bottom = 32.dp)
                ) {}
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
                    text = "Резюме для отклика",
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