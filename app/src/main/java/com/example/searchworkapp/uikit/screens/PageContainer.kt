package com.example.searchworkapp.uikit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.searchworkapp.uikit.theme.AppTheme


@Composable
internal fun PageContainer(
    modifier: Modifier = Modifier,
    background: Color = AppTheme.colors.shadows,
    brush: Brush? = null,
    fill: Boolean = true,
    line: Boolean = true,
    isLoading: State<Boolean> = mutableStateOf(false),
    header: @Composable (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit,
    footer: @Composable (BoxScope.() -> Unit)? = null,
) {
    var modifier = if (brush != null) {
        modifier.background(brush)
    } else {
        modifier.background(background)
    }
    modifier = if (fill) {
        modifier
            .fillMaxHeight()
            .windowInsetsPadding(WindowInsets.safeDrawing)
    } else {
        modifier.padding(bottom = 12.dp)
    }
    val localFocusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            }
    ) {
        if (!fill) {
            Box(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(AppTheme.colors.gray2).width(38.dp).height(5.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            header?.invoke()
        }

        Box(
            modifier = Modifier
                .weight(1f, fill)
        ) {
            content()
//            ErrorMessageView(error = error)
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            footer?.invoke(this)
        }
    }


    if (isLoading.value) {
//        LoadingView(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Black.copy(alpha = 0.5F))
//        )
    }
}

