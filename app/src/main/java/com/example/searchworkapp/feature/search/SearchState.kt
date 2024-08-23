package com.example.searchworkapp.feature.search

import com.example.searchworkapp.domain.model.VacancyUI

data class SearchState(
    val search: String,
    val vacancy: List<VacancyUI>
) {
    companion object {
        val Default = SearchState(search = "", vacancy = emptyList())
    }

}