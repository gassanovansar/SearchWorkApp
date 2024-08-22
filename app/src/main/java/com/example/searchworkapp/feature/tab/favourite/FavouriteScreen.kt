package com.example.searchworkapp.feature.tab.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.searchworkapp.feature.detail.DetailScreen
import com.example.searchworkapp.feature.sendRequest.SendRequestBottomScreen
import com.example.searchworkapp.feature.tab.search.SearchItem
import com.example.searchworkapp.uikit.designe.toolBar.Toolbar
import com.example.searchworkapp.uikit.screens.PageContainer
import com.example.searchworkapp.uikit.theme.AppTheme

class FavouriteScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val bottomSheetNavigator = LocalBottomSheetNavigator.current
        PageContainer(header = {
            Toolbar(startTitle = "Избранное")
        }, content = {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {

                item {
                    Text(
                        text = "1 вакансия",
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.gray3,
                        )
                    )
                }
                items(4) {
                    SearchItem(onClick = {
                        navigator.push(DetailScreen())
                    }, replyOnClick = {
                        bottomSheetNavigator.show(SendRequestBottomScreen())
                    })
                }

            }
        })
    }
}