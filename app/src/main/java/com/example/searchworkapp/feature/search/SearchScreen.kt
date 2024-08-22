package com.example.searchworkapp.feature.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.searchworkapp.feature.tab.search.SearchItem
import com.example.searchworkapp.uikit.designe.appCard.AppCard
import com.example.searchworkapp.uikit.designe.appTextFiled.AppTextField
import com.example.searchworkapp.uikit.screens.PageContainer
import com.example.searchworkapp.uikit.theme.AppTheme

class SearchScreen : Screen {
    @Composable
    override fun Content() {
        PageContainer(
            header = {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp, bottom = 8.dp)
                ) {
                    AppTextField(value = "", modifier = Modifier.weight(1f)) {}
                    AppCard(
                        backgroundColor = AppTheme.colors.white,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(40.dp)
                    ) {
                    }
                }
            },
            content = {
                Column {
                    Row(
                        Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 8.dp, bottom = 9.dp)) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "145 вакансий",
                            style = AppTheme.typography.regular.copy(
                                fontSize = 14.sp,
                                lineHeight = 16.8.sp,
                                color = AppTheme.colors.white,
                            )
                        )

                        Row {
                            Text(
                                text = "По соответствию",
                                style = AppTheme.typography.regular.copy(
                                    fontSize = 14.sp,
                                    lineHeight = 16.8.sp,
                                    color = AppTheme.colors.blue,
                                )
                            )
                            //TODO FIX

                            AppCard(
                                backgroundColor = AppTheme.colors.white,
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .size(16.dp)
                            ) {
                            }
                        }

                    }

                    LazyColumn(
                        modifier = Modifier.padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(10) {
                            SearchItem()
                        }
                    }
                }
            })
    }
}