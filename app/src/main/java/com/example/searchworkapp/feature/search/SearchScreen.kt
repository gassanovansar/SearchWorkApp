package com.example.searchworkapp.feature.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.searchworkapp.R
import com.example.searchworkapp.base.ext.clickableRound
import com.example.searchworkapp.feature.detail.DetailScreen
import com.example.searchworkapp.feature.sendRequest.SendRequestBottomScreen
import com.example.searchworkapp.feature.tab.search.SearchItem
import com.example.searchworkapp.uikit.designe.appCard.AppCard
import com.example.searchworkapp.uikit.designe.appTextFiled.AppTextField
import com.example.searchworkapp.uikit.screens.PageContainer
import com.example.searchworkapp.uikit.theme.AppTheme

class SearchScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val bottomSheetNavigator = LocalBottomSheetNavigator.current
        val viewModel = rememberScreenModel { SearchScreenModel() }
        val state by viewModel.state.collectAsState()
        LaunchedEffect(viewModel) {
            viewModel.loadVacancies()
        }

        PageContainer(
            header = {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp, bottom = 8.dp)
                ) {
                    AppTextField(
                        value = state.search,
                        modifier = Modifier.weight(1f),
                        hint = "Должность, ключевые слова",
                        left = {
                            Image(
                                modifier = Modifier.clickableRound(4.dp) {
                                    navigator.pop()
                                },
                                painter = painterResource(id = R.drawable.ic_back),
                                contentDescription = ""
                            )
                        }
                    ) {
                        viewModel.changeSearch(it)
                    }
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

                Column {
                    Row(
                        Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 8.dp, bottom = 9.dp)
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = pluralStringResource(id = R.plurals.vacancy_1, state.vacancy.size,state.vacancy.size),
                            style = AppTheme.typography.regular.copy(
                                fontSize = 14.sp,
                                lineHeight = 16.8.sp,
                                color = AppTheme.colors.white,
                            )
                        )

                        Row {
                            Text(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                text = "По соответствию",
                                style = AppTheme.typography.regular.copy(
                                    fontSize = 14.sp,
                                    lineHeight = 16.8.sp,
                                    color = AppTheme.colors.blue,
                                )
                            )

                            Image(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(start = 8.dp),
                                painter = painterResource(id = R.drawable.ic_arrows),
                                contentDescription = ""
                            )
                        }

                    }

                    LazyColumn(
                        modifier = Modifier.padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(state.vacancy) {
                            SearchItem(onClick = {
                                navigator.push(DetailScreen(it.id))
                            }, isFavouriteOnClick = {
                                viewModel.isFavourites(it)
                            }, item = it)
                        }
                    }
                }
                AppCard(
                    backgroundColor = AppTheme.colors.gray2,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 16.dp, bottom = 24.dp),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Row(Modifier.padding(12.dp)) {
                        Image(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            painter = painterResource(id = R.drawable.ic_map),
                            contentDescription = ""
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .align(Alignment.CenterVertically),
                            text = "Карта",
                            style = AppTheme.typography.medium.copy(
                                fontSize = 16.sp,
                                lineHeight = 19.2.sp,
                                color = AppTheme.colors.white,
                            )
                        )
                    }

                }
            })
    }
}