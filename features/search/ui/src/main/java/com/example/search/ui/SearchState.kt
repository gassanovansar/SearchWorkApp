package com.example.search.ui

import com.example.models.VacancyUI

data class SearchState(
    val search: String,
    val vacancy: List<VacancyUI>
) {
    companion object {
        val Default = SearchState(search = "", vacancy = emptyList())
    }

}