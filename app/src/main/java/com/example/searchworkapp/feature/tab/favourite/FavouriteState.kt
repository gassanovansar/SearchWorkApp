package com.example.searchworkapp.feature.tab.favourite

import com.example.models.VacancyUI

data class FavouriteState(val favourites: List<VacancyUI>) {
    companion object {
        val Default = FavouriteState(favourites = emptyList())
    }
}