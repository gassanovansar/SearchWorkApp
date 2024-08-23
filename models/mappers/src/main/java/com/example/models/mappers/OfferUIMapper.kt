package com.example.models.mappers

import com.example.models.data.OfferButtonResponse
import com.example.models.data.OfferResponse
import com.example.models.domain.OfferUI

fun OfferResponse.toUI(): OfferUI {

    return OfferUI(
        id = this.id.orEmpty(),
        title = this.title.orEmpty(),
        button = this.button?.toUI() ?: com.example.models.domain.OfferButtonUI.Default,
        icon = when (this.id.orEmpty()) {
            "near_vacancies" -> com.example.models.domain.Icon.NearVacancies
            "level_up_resume" -> com.example.models.domain.Icon.LevelUpResume
            "temporary_job" -> com.example.models.domain.Icon.TemporaryJob
            else -> {
                com.example.models.domain.Icon.Empty
            }
        },
        link = this.link.orEmpty()
    )
}

fun OfferButtonResponse.toUI(): com.example.models.domain.OfferButtonUI {
    return com.example.models.domain.OfferButtonUI(title = this.text.orEmpty())
}