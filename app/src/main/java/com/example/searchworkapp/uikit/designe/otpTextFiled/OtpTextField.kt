package com.example.searchworkapp.uikit.designe.otpTextFiled

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.searchworkapp.uikit.designe.appCard.AppCard
import com.example.searchworkapp.uikit.theme.AppTheme

@Composable
internal fun OtpTextField(
    modifier: Modifier = Modifier,
    otpText: String,
    otpCount: Int = 4,
    isError: Boolean = false,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    LaunchedEffect(Unit) {
        if (otpText.length > otpCount) {
            throw IllegalArgumentException("Otp text value must not have more than otpCount: $otpCount characters")
        }
    }

    BasicTextField(
        modifier = modifier,
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = {
            if (it.text.length <= otpCount) {
                onOtpTextChange.invoke(it.text, it.text.length == otpCount)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        cursorBrush = SolidColor(AppTheme.colors.gray5),
        singleLine = true,
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        text = otpText,
                        isError = isError
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String,
    isError: Boolean = false
) {
    //val isFocused = text.length == index
    val char = when {
        index == text.length -> "|"
        index > text.length -> "*"
        else -> text[index].toString()
    }
    val borderColor = when {
        index == text.length -> AppTheme.colors.gray2
        index > text.length -> AppTheme.colors.gray2
        else -> AppTheme.colors.gray2
    }
    val textColor = if (isError) AppTheme.colors.red else when {
        index == text.length -> if (char == "|") AppTheme.colors.gray3 else AppTheme.colors.white
        index > text.length -> AppTheme.colors.gray3
        else -> AppTheme.colors.white
    }
    val color = if (isError) {
        AppTheme.colors.red
    } else {
        borderColor
    }

    AppCard(
        backgroundColor = AppTheme.colors.gray2, modifier = Modifier
            .width(48.dp)
            .height(48.dp)
            .padding(horizontal = 2.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = char,
            maxLines = 1,
            style = AppTheme.typography.regular.copy(
                color = textColor,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
            )
        )

    }
}
