package com.example.searchworkapp.feature.tab

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.searchworkapp.R
import com.example.searchworkapp.feature.tab.favourite.FavouriteScreen
import com.example.searchworkapp.feature.tab.search.MainScreen

object FavouriteTabScreen : Tab {

    @Composable
    override fun Content() {
        Navigator(FavouriteScreen()) {
            CurrentScreen()
        }
    }


    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1.toUShort(),
            title = "Избранное",
            icon = painterResource(id = R.drawable.ic_favourite_off)
        )
}