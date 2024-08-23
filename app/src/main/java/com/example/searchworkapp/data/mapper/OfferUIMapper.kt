package com.example.searchworkapp.data.mapper

import com.example.searchworkapp.data.model.OfferButtonResponse
import com.example.searchworkapp.data.model.OfferResponse
import com.example.models.Icon
import com.example.models.OfferButtonUI
import com.example.models.OfferUI

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