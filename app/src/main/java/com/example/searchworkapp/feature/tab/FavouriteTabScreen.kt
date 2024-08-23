package com.example.searchworkapp.feature.tab

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.searchworkapp.R
import com.example.searchworkapp.base.BaseAuthTab
import com.example.searchworkapp.feature.tab.favourite.FavouriteScreen

object FavouriteTabScreen : BaseAuthTab {
    override val key: ScreenKey = "FavouriteTabScreen"

    @Composable
    override fun AuthContent() {
        Navigator(screen = FavouriteScreen())
    }


    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1.toUShort(),
            title = "Избранное",
            icon = painterResource(id = R.drawable.ic_favourite_off)
        )
}