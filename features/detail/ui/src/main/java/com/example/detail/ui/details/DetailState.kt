package com.example.detail.ui.details

import com.example.models.VacancyUI


data class DetailState(val vacancy: VacancyUI) {
    companion object {
        val Default = DetailState(vacancy = VacancyUI.Default)
    }
}