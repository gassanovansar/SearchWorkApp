package com.example.favourite.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.core.RootNavigator
import com.example.detail.ui.details.DetailScreen
import com.example.uikit.components.SearchItem
import com.example.uikit.designe.toolBar.Toolbar
import com.example.uikit.screens.PageContainer
import com.example.uikit.theme.AppTheme

class FavouriteScreen : Screen {
    @Composable
    override fun Content() {
        val rootNavigator = RootNavigator.currentOrThrow
        val viewModel = rememberScreenModel { FavouriteScreenModel() }
        val state by viewModel.state.collectAsState()
        LaunchedEffect(viewModel) {
            viewModel.loadFavourites()
        }
        PageContainer(
            isLoading = viewModel.status.collectAsState(false),
            header = {
            Toolbar(startTitle = "Избранное")
        }, content = {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {

                item {
                    Text(
                        text = pluralStringResource(id = R.plurals.vacancy_1, state.favourites.size, state.favourites.size),
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.gray3,
                        )
                    )
                }
                items(state.favourites) {
                    SearchItem(item = it, onClick = {
                        rootNavigator.push(DetailScreen(it.id))
                    }, isFavouriteOnClick = {
                        viewModel.isFavourites(it)
                    })
                }

            }
        })
    }
}