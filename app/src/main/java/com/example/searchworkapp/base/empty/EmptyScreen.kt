package com.example.searchworkapp.base.empty

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.searchworkapp.uikit.screens.PageContainer
import com.example.searchworkapp.uikit.theme.AppTheme

class EmptyScreen : Screen {
    @Composable
    override fun Content() {
        PageContainer(content = {
            Box(modifier = Modifier.fillMaxSize()){
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Не реализовано",
                    style = AppTheme.typography.semiBold.copy(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        color = AppTheme.colors.white,
                    )
                )
            }

        })
    }
}