package com.example.searchworkapp.feature.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.searchworkapp.R
import com.example.searchworkapp.uikit.designe.appCard.AppCard
import com.example.searchworkapp.uikit.designe.button.ButtonColor
import com.example.searchworkapp.uikit.designe.button.PrimaryButton
import com.example.searchworkapp.uikit.designe.toolBar.BackIcon
import com.example.searchworkapp.uikit.designe.toolBar.Toolbar
import com.example.searchworkapp.uikit.screens.PageContainer
import com.example.searchworkapp.uikit.theme.AppTheme

class DetailScreen : Screen {
    @Composable
    override fun Content() {
        PageContainer(
            header = {
                Toolbar(leftIcon = { BackIcon() }, rightIcon = {
                    Row {
                        Image(
                            painterResource(R.drawable.ic_eye),
                            contentDescription = "",
                        )
                        Image(
                            painterResource(R.drawable.ic_share),
                            contentDescription = "",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Image(
                            painterResource(R.drawable.ic_favourite_on),
                            contentDescription = "",
                        )

                    }
                })
            },
            content = {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "UI/UX Designer",
                        style = AppTheme.typography.semiBold.copy(
                            fontSize = 22.sp,
                            lineHeight = 26.4.sp,
                            color = AppTheme.colors.white,
                        )
                    )
                    Text(
                        modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
                        text = "Уровень дохода не указан",
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Требуемый опыт: от 1 года до 3 лет",
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 6.dp)
                            .padding(horizontal = 16.dp),
                        text = "Полная занятость, полный день",
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Row(modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 24.dp)) {
                        GreenItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            title = "147 человек уже откликнулись",
                            image = R.drawable.ic_circle_profile
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        GreenItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            title = "2 человека сейчас смотрят",
                            image = R.drawable.ic_circle_eye
                        )
                    }
                    MapItem(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 24.dp)
                    )

                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "MOBYRIX - динамично развивающаяся продуктовая IT-компания, специализирующаяся на разработке мобильных приложений для iOS и Android. Наша команда работает над собственными продуктами в разнообразных сферах: от утилит до развлечений и бизнес-приложений. Мы ценим талант и стремление к инновациям и в данный момент в поиске талантливого UX/UI Designer, готового присоединиться к нашей команде и внести значимый вклад в развитие наших проектов.",
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Ваши задачи",
                        style = AppTheme.typography.semiBold.copy(
                            fontSize = 20.sp,
                            lineHeight = 24.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 8.dp),
                        text = "-Проектировать пользовательский опыт, проводить UX исследования; -Разрабатывать адаптивный дизайн интерфейса для мобильных приложений; -Разрабатывать быстрые прототипы для тестирования идеи дизайна и их последующая; интеграция на основе обратной связи от команды и пользователей; -Взаимодействовать с командой разработчиков для обеспечения точной реализации ваших дизайнов; -Анализ пользовательского опыта и адаптация под тренды.",
                        style = AppTheme.typography.regular.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 32.dp)
                            .padding(horizontal = 16.dp),
                        text = "Задайте вопрос работодателю",
                        style = AppTheme.typography.medium.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.white,
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .padding(horizontal = 16.dp),
                        text = "Он получит его с откликом на вакансию",
                        style = AppTheme.typography.medium.copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp,
                            color = AppTheme.colors.gray3,
                        )
                    )
                    Spacer(modifier = Modifier.size(16.dp))

                    (0..4).forEachIndexed { index, it ->
                        QuestionsItem(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            title = "Где распологается место работы?"
                        )
                        if (index != 4) {
                            Spacer(modifier = Modifier.size(8.dp))
                        }
                    }
                    PrimaryButton(
                        text = "Откликнуться",
                        backgroundColor = ButtonColor.GREEN,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {}


                }

            })
    }


    @Composable
    private fun GreenItem(modifier: Modifier = Modifier, title: String, image: Int) {
        AppCard(modifier = modifier, backgroundColor = AppTheme.colors.darkGreen) {
            Row(Modifier.padding(8.dp)) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    style = AppTheme.typography.regular.copy(
                        fontSize = 14.sp,
                        lineHeight = 16.8.sp,
                        color = AppTheme.colors.white,
                    ),
                    maxLines = 2
                )

                Image(
                    painterResource(image),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 16.dp)
                )


            }

        }
    }

    @Composable
    private fun MapItem(modifier: Modifier) {
        AppCard(modifier) {
            Column(modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)) {
                Row {
                    Text(
                        text = "Мобирикс",
                        style = AppTheme.typography.medium.copy(
                            fontSize = 16.sp,
                            lineHeight = 19.2.sp,
                            color = AppTheme.colors.white,
                        )
                    )
                    Image(
                        painterResource(R.drawable.ic_circle_check),
                        contentDescription = "",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Image(
                    painterResource(R.drawable.ic_default_map),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                Text(
                    text = "Минск, улица Бирюзова, 4/5",
                    style = AppTheme.typography.regular.copy(
                        fontSize = 14.sp,
                        lineHeight = 16.8.sp,
                        color = AppTheme.colors.white,
                    )
                )
            }
        }
    }

    @Composable
    private fun QuestionsItem(modifier: Modifier, title: String) {
        AppCard(
            modifier = modifier,
            backgroundColor = AppTheme.colors.gray2,
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                text = title,
                style = AppTheme.typography.medium.copy(
                    fontSize = 14.sp,
                    lineHeight = 16.8.sp,
                    color = AppTheme.colors.white,
                )
            )
        }
    }
}