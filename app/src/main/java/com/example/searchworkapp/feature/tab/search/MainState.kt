package com.example.searchworkapp.feature.tab.search

import com.example.searchworkapp.domain.model.OfferUI
import com.example.searchworkapp.domain.model.VacancyUI

data class MainState(
    val offers: List<OfferUI>,
    val vacancy: List<VacancyUI>
) {
    companion object {
        val Default = MainState(offers = emptyList(), vacancy = emptyList())
    }

}