package com.example.ui

import com.example.models.domain.OfferUI
import com.example.models.domain.VacancyUI

data class MainState(
    val offers: List<OfferUI>,
    val vacancy: List<VacancyUI>
) {
    companion object {
        val Default = MainState(offers = emptyList(), vacancy = emptyList())
    }

}