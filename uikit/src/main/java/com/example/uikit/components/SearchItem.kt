package com.example.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.ext.clickableDebounce
import com.example.core.ext.clickableRound
import com.example.models.VacancyUI
import com.example.uikit.R
import com.example.uikit.designe.appCard.AppCard
import com.example.uikit.designe.button.ButtonColor
import com.example.uikit.designe.button.PrimaryButton
import com.example.uikit.designe.button.Round
import com.example.uikit.designe.button.Size
import com.example.uikit.theme.AppTheme

@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    item: VacancyUI,
    onClick: () -> Unit,
    isFavouriteOnClick: () -> Unit,
) {

    AppCard(modifier = modifier.clickableRound(8.dp) {
        onClick()
    }) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row {
                Column(modifier = Modifier.weight(1f)) {
                    if (item.lookingNumber != 0) {
                        Text(
                            modifier = Modifier.padding(bottom = 10.dp),
                            text = pluralStringResource(id = R.plurals.human, item.lookingNumber,item.lookingNumber),
                            style = AppTheme.typography.regular.copy(
                                fontSize = 14.sp,
                                lineHeight = 16.8.sp,
                                color = AppTheme.colors.green,
                            )
                        )
                    }

                    Text(
                        text = item.title,
                        style = AppTheme.typography.medium.copy(
                            fontSize = 16.sp,
                            lineHeight = 19.2.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = item.address.town,
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Row(modifier = Modifier.padding(top = 4.dp)) {
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = item.company,
                            style = AppTheme.typography.regular.copy(
                                fontSize = 14.sp,
                                lineHeight = 16.8.sp,
                                color = AppTheme.colors.white,
                            )
                        )
                        Image(
                            painterResource(id = R.drawable.ic_circle_check),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .align(Alignment.CenterVertically),
                        )
                    }
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Image(
                            painterResource(id = R.drawable.ic_suitcase),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .align(Alignment.CenterVertically),
                        )
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = item.experience.previewText,
                            style = AppTheme.typography.regular.copy(
                                fontSize = 14.sp,
                                lineHeight = 16.8.sp,
                                color = AppTheme.colors.white,
                            )
                        )
                    }

                    //TODO FIX
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Опубликовано 20 февраля",
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.gray3,
                        )
                    )
                }
                Image(
                    painterResource(id = if (item.isFavorite) R.drawable.ic_favourite_on else R.drawable.ic_favourite_off),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                        .clickableDebounce {
                            isFavouriteOnClick()
                        }
                )

            }

            PrimaryButton(
                text = "Откликнуться",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 21.dp),
                backgroundColor = ButtonColor.GREEN,
                round = Round.CIRCLE,
                size = Size.L
            ) { }
        }


    }
}