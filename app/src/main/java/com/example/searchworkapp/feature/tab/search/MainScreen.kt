package com.example.searchworkapp.feature.tab.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.searchworkapp.R
import com.example.searchworkapp.base.ext.clickableDebounce
import com.example.searchworkapp.base.ext.clickableRound
import com.example.searchworkapp.domain.model.Icon
import com.example.searchworkapp.domain.model.OfferUI
import com.example.searchworkapp.domain.model.VacancyUI
import com.example.searchworkapp.feature.detail.DetailScreen
import com.example.searchworkapp.feature.search.SearchScreen
import com.example.searchworkapp.uikit.designe.appCard.AppCard
import com.example.searchworkapp.uikit.designe.appTextFiled.AppTextField
import com.example.searchworkapp.uikit.designe.button.ButtonColor
import com.example.searchworkapp.uikit.designe.button.PrimaryButton
import com.example.searchworkapp.uikit.designe.button.Round
import com.example.searchworkapp.uikit.designe.button.Size
import com.example.searchworkapp.uikit.screens.PageContainer
import com.example.searchworkapp.uikit.theme.AppTheme


class MainScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val bottomSheetNavigator = LocalBottomSheetNavigator.current
        val viewModel = rememberScreenModel { MainScreenModel() }
        val state by viewModel.state.collectAsState()
        LaunchedEffect(viewModel) {
            viewModel.loadOffers()
            viewModel.loadVacancies()
        }
        PageContainer(
            isLoading = viewModel.loading.collectAsState(false),
            header = {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp, bottom = 8.dp)
                ) {
                    AppTextField(
                        value = "",
                        modifier = Modifier.weight(1f),
                        enabled = false,
                        hint = "Должность, ключевые слова",
                        left = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = ""
                            )
                        },
                        onClick = {
                            navigator.push(SearchScreen())
                        }) {}
                    AppCard(
                        backgroundColor = AppTheme.colors.gray2,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(40.dp)
                    ) {
                        Image(
                            modifier = Modifier.align(Alignment.Center),
                            painter = painterResource(id = R.drawable.ic_filter),
                            contentDescription = ""
                        )
                    }
                }
            },
            content = {
                LazyColumn {
                    if (state.offers.isNotEmpty()) {
                        item {
                            LazyRow(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                            ) {
                                items(state.offers) {
                                    BannerItem(it)
                                }
                            }
                        }
                    }
                    item {
                        Text(
                            modifier = Modifier.padding(top = 24.dp, start = 16.dp),
                            text = "Вакансии для вас",
                            style = AppTheme.typography.semiBold.copy(
                                fontSize = 20.sp,
                                lineHeight = 24.sp,
                                color = AppTheme.colors.white,
                            )
                        )
                    }
                    items(state.vacancy.take(3)) {
                        Spacer(modifier = Modifier.size(16.dp))
                        SearchItem(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            item = it,
                            onClick = {
                                navigator.push(DetailScreen(it.id))
                            },
                            isFavouriteOnClick = {
                                viewModel.isFavourites(it)
                            })
                    }

                    item {
                        Spacer(modifier = Modifier.size(16.dp))
                        if (state.vacancy.size > 3) {
                            PrimaryButton(
                                text =pluralStringResource(id = R.plurals.vacancy, state.vacancy.size - 3,state.vacancy.size - 3),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp, bottom = 8.dp)
                                    .padding(horizontal = 16.dp)
                            ) {
                                navigator.push(SearchScreen())
                            }
                        }
                    }
                }
            })
    }

    @Composable
    private fun BannerItem(item: OfferUI) {
        val uriHandler = LocalUriHandler.current
        AppCard(modifier = Modifier
            .size(width = 132.dp, height = 120.dp)
            .clickableRound(8.dp) {
                if (item.link.isNotBlank()) {
                    uriHandler.openUri(item.link)
                }
            }) {
            Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp)) {
                Image(
                    modifier = Modifier,
                    painter = painterResource(
                        id = when (item.icon) {
                            Icon.NearVacancies -> R.drawable.ic_near_vacancies
                            Icon.LevelUpResume -> R.drawable.ic_level_up_resume
                            Icon.TemporaryJob -> R.drawable.ic_temporary_job
                            Icon.Empty -> R.drawable.ic_empty
                        }
                    ), contentDescription = ""
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = item.title,
                    style = AppTheme.typography.medium.copy(
                        fontSize = 14.sp,
                        lineHeight = 16.8.sp,
                        color = AppTheme.colors.white,
                    ),
                    maxLines = if (item.button.title.isEmpty()) 3 else 2,
                    overflow = TextOverflow.Ellipsis
                )
                if (item.button.title.isNotEmpty()) {
                    Text(
                        text = item.button.title,
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.green,
                        )
                    )
                }


            }

        }
    }
}


@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    item: VacancyUI,
    onClick: () -> Unit,
    isFavouriteOnClick: () -> Unit,
) {

    AppCard(modifier = modifier.clickableRound(8.dp) {
        onClick()
    }) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row {
                Column(modifier = Modifier.weight(1f)) {
                    if (item.lookingNumber != 0) {
                        Text(
                            modifier = Modifier.padding(bottom = 10.dp),
                            text = pluralStringResource(id = R.plurals.human, item.lookingNumber,item.lookingNumber),
                            style = AppTheme.typography.regular.copy(
                                fontSize = 14.sp,
                                lineHeight = 16.8.sp,
                                color = AppTheme.colors.green,
                            )
                        )
                    }

                    Text(
                        text = item.title,
                        style = AppTheme.typography.medium.copy(
                            fontSize = 16.sp,
                            lineHeight = 19.2.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = item.address.town,
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Row(modifier = Modifier.padding(top = 4.dp)) {
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = item.company,
                            style = AppTheme.typography.regular.copy(
                                fontSize = 14.sp,
                                lineHeight = 16.8.sp,
                                color = AppTheme.colors.white,
                            )
                        )
                        Image(
                            painterResource(id = R.drawable.ic_circle_check),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .align(Alignment.CenterVertically),
                        )
                    }
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Image(
                            painterResource(id = R.drawable.ic_suitcase),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .align(Alignment.CenterVertically),
                        )
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = item.experience.previewText,
                            style = AppTheme.typography.regular.copy(
                                fontSize = 14.sp,
                                lineHeight = 16.8.sp,
                                color = AppTheme.colors.white,
                            )
                        )
                    }

                    //TODO FIX
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Опубликовано 20 февраля",
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.gray3,
                        )
                    )
                }
                Image(
                    painterResource(id = if (item.isFavorite) R.drawable.ic_favourite_on else R.drawable.ic_favourite_off),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                        .clickableDebounce {
                            isFavouriteOnClick()
                        }
                )

            }

            PrimaryButton(
                text = "Откликнуться",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 21.dp),
                backgroundColor = ButtonColor.GREEN,
                round = Round.CIRCLE,
                size = Size.L
            ) { }
        }


    }
}