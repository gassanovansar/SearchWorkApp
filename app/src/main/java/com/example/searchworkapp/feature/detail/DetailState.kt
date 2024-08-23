package com.example.searchworkapp.feature.detail

import com.example.searchworkapp.domain.model.VacancyUI

data class DetailState(val vacancy: VacancyUI) {
    companion object{
        val Default = DetailState(vacancy = VacancyUI.Default)
    }
}