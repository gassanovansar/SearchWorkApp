package com.example.searchworkapp.feature.tab.favourite

import com.example.searchworkapp.domain.model.VacancyUI

data class FavouriteState(val favourites: List<VacancyUI>) {
    companion object {
        val Default = FavouriteState(favourites = emptyList())
    }
}