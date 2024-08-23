package com.example.searchworkapp.domain.mapper

import com.example.searchworkapp.data.model.OfferButtonResponse
import com.example.searchworkapp.data.model.OfferResponse
import com.example.searchworkapp.domain.model.Icon
import com.example.searchworkapp.domain.model.OfferButtonUI
import com.example.searchworkapp.domain.model.OfferUI

fun OfferResponse.toUI(): OfferUI {

    return OfferUI(
        id = this.id.orEmpty(),
        title = this.title.orEmpty(),
        button = this.button?.toUI() ?: OfferButtonUI.Default,
        icon = when (this.id.orEmpty()) {
            "near_vacancies" -> Icon.NearVacancies
            "level_up_resume" -> Icon.LevelUpResume
            "temporary_job" -> Icon.TemporaryJob
            else -> {
                Icon.Empty
            }
        },
        link = this.link.orEmpty()
    )
}

fun OfferButtonResponse.toUI(): OfferButtonUI {
    return OfferButtonUI(title = this.text.orEmpty())
}