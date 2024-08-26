package com.example.uikit.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.uikit.R
import com.example.uikit.theme.AppTheme

class BaseEmptyScreen : Screen {
    @Composable
    override fun Content() {
        PageContainer(content = {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(id = R.string.not_implemented),
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