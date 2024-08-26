package com.example.searchworkapp.feature.tab

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.searchworkapp.R
import com.example.searchworkapp.base.BaseAuthTab
import com.example.uikit.screens.BaseEmptyScreen

object ResponsesTabScreen : Tab, BaseAuthTab {

    @Composable
    override fun AuthContent() {
        Navigator(BaseEmptyScreen())
    }


    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1.toUShort(),
            title = "Отклики",
            icon = painterResource(id = R.drawable.ic_envelope)
        )
}