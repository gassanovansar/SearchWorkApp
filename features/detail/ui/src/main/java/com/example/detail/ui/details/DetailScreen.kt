package com.example.detail.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import com.example.core.ext.clickableDebounce
import com.example.core.ext.clickableRound
import com.example.detail.ui.R
import com.example.detail.ui.sendRequest.SendRequestBottomScreen
import com.example.models.VacancyAddressUI
import com.example.uikit.designe.appCard.AppCard
import com.example.uikit.designe.button.ButtonColor
import com.example.uikit.designe.button.PrimaryButton
import com.example.uikit.designe.toolBar.BackIcon
import com.example.uikit.designe.toolBar.Toolbar
import com.example.uikit.screens.PageContainer
import com.example.uikit.theme.AppTheme

class DetailScreen( val id: String) : Screen {
    @Composable
    override fun Content() {
        val bottomSheetNavigator = LocalBottomSheetNavigator.current
        val viewModel = rememberScreenModel { DetailScreenModel() }
        val state by viewModel.state.collectAsState()
        LaunchedEffect(viewModel) {
            viewModel.loadVacancy(id)
        }
        PageContainer(
            header = {
                Toolbar(leftIcon = { BackIcon() }, rightIcon = {
                    Row {
                        Image(
                            painterResource(R.drawable.ic_eye),
                            contentDescription = "",
                        )
                        Image(
                            painterResource(R.drawable.ic_share),
                            contentDescription = "",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Image(
                            modifier = Modifier.clickableDebounce {
                                viewModel.isFavourites()
                            },
                            painter = painterResource(if (state.vacancy.isFavorite) R.drawable.ic_favourite_on else R.drawable.ic_favourite_off),
                            contentDescription = "",
                        )

                    }
                })
            },
            content = {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = state.vacancy.title,
                        style = AppTheme.typography.semiBold.copy(
                            fontSize = 22.sp,
                            lineHeight = 26.4.sp,
                            color = AppTheme.colors.white,
                        )
                    )
                    Text(
                        modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
                        text = state.vacancy.salary.full,
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Требуемый опыт: ${state.vacancy.experience.previewText}",
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 6.dp)
                            .padding(horizontal = 16.dp),
                        text = state.vacancy.schedules.joinToString(", ")
                            .replaceFirstChar(Char::titlecase),
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 24.dp)
                    ) {
                        if (state.vacancy.appliedNumber > 0) {
                            GreenItem(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                title = pluralStringResource(
                                    id = R.plurals.human_1,
                                    state.vacancy.appliedNumber,
                                    state.vacancy.appliedNumber
                                ),
                                image = R.drawable.ic_circle_profile
                            )
                        }
                        if (state.vacancy.lookingNumber > 0 && state.vacancy.appliedNumber > 0) {
                            Spacer(modifier = Modifier.size(8.dp))
                        }

                        if (state.vacancy.lookingNumber > 0) {
                            GreenItem(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                title = pluralStringResource(
                                    id = R.plurals.human_2,
                                    state.vacancy.lookingNumber,
                                    state.vacancy.lookingNumber
                                ),
                                image = R.drawable.ic_circle_eye
                            )
                        }

                    }
                    MapItem(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 24.dp), state.vacancy.address, state.vacancy.company
                    )

                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = state.vacancy.description,
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Ваши задачи",
                        style = AppTheme.typography.semiBold.copy(
                            fontSize = 20.sp,
                            lineHeight = 24.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 8.dp),
                        text = state.vacancy.responsibilities,
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 32.dp)
                            .padding(horizontal = 16.dp),
                        text = "Задайте вопрос работодателю",
                        style = AppTheme.typography.medium.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .padding(horizontal = 16.dp),
                        text = "Он получит его с откликом на вакансию",
                        style = AppTheme.typography.medium.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.gray3,
                        )
                    )
                    Spacer(modifier = Modifier.size(16.dp))

                    state.vacancy.questions.forEachIndexed { index, it ->
                        QuestionsItem(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            title = it
                        ) {
                            bottomSheetNavigator.show(SendRequestBottomScreen(it))
                        }
                        if (index != 4) {
                            Spacer(modifier = Modifier.size(8.dp))
                        }
                    }
                    PrimaryButton(
                        text = "Откликнуться",
                        backgroundColor = ButtonColor.GREEN,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        bottomSheetNavigator.show(SendRequestBottomScreen())
                    }
                }

            })
    }


    @Composable
    private fun GreenItem(modifier: Modifier = Modifier, title: String, image: Int) {
        AppCard(modifier = modifier, backgroundColor = AppTheme.colors.darkGreen) {
            Row(Modifier.padding(8.dp)) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    style = AppTheme.typography.regular.copy(
                        fontSize = 14.sp,
                        lineHeight = 16.8.sp,
                        color = AppTheme.colors.white,
                    ),
                    minLines = 2,
                    maxLines = 2
                )

                Image(
                    painterResource(image),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 16.dp)
                )


            }

        }
    }

    @Composable
    private fun MapItem(modifier: Modifier, item: VacancyAddressUI, company: String) {
        AppCard(modifier) {
            Column(modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)) {
                Row {
                    Text(
                        text = company,
                        style = AppTheme.typography.medium.copy(
                            fontSize = 16.sp,
                            lineHeight = 19.2.sp,
                            color = AppTheme.colors.white,
                        )
                    )
                    Image(
                        painterResource(R.drawable.ic_circle_check),
                        contentDescription = "",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Image(
                    painterResource(R.drawable.ic_default_map),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                val address = listOf(item.town, item.street, item.house)

                Text(
                    text = address.joinToString(", "),
                    style = AppTheme.typography.regular.copy(
                        fontSize = 14.sp,
                        lineHeight = 16.8.sp,
                        color = AppTheme.colors.white,
                    )
                )
            }
        }
    }

    @Composable
    private fun QuestionsItem(modifier: Modifier, title: String, onClick: () -> Unit) {
        AppCard(
            modifier = modifier.clickableRound(50.dp) {
                onClick()
            },
            backgroundColor = AppTheme.colors.gray2,
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                text = title,
                style = AppTheme.typography.medium.copy(
                    fontSize = 14.sp,
                    lineHeight = 16.8.sp,
                    color = AppTheme.colors.white,
                )
            )
        }
    }
}