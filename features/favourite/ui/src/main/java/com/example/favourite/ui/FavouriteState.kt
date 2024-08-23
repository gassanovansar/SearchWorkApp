package com.example.favourite.ui

import com.example.models.VacancyUI

data class FavouriteState(val favourites: List<VacancyUI>) {
    companion object {
        val Default = FavouriteState(favourites = emptyList())
    }
}