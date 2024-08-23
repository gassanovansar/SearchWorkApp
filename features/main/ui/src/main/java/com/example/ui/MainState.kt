package com.example.ui

import com.example.models.OfferUI
import com.example.models.VacancyUI

data class MainState(
    val offers: List<OfferUI>,
    val vacancy: List<VacancyUI>
) {
    companion object {
        val Default = MainState(offers = emptyList(), vacancy = emptyList())
    }

}