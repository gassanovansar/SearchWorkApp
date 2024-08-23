package com.example.favourite.ui

import com.example.models.domain.VacancyUI

data class FavouriteState(val favourites: List<VacancyUI>) {
    companion object {
        val Default = FavouriteState(favourites = emptyList())
    }
}