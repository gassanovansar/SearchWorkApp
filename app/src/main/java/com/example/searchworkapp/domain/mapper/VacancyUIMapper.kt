package com.example.searchworkapp.domain.mapper

import com.example.searchworkapp.data.source.VacanciesAddressResponse
import com.example.searchworkapp.data.source.VacanciesExperienceResponse
import com.example.searchworkapp.data.source.VacanciesResponse
import com.example.searchworkapp.data.source.VacanciesSalaryResponse
import com.example.searchworkapp.domain.model.VacancyAddressUI
import com.example.searchworkapp.domain.model.VacancyExperienceUI
import com.example.searchworkapp.domain.model.VacancySalaryUI
import com.example.searchworkapp.domain.model.VacancyUI

fun VacanciesResponse.toUI(): VacancyUI {
    return VacancyUI(
        id = this.id.orEmpty(),
        lookingNumber = this.lookingNumber ?: 0,
        title = this.title.orEmpty(),
        address = this.address?.toUI() ?: VacancyAddressUI.Default,
        company = this.company.orEmpty(),
        experience = this.experience?.toUI() ?: VacancyExperienceUI.Default,
        publishedDate = this.publishedDate.orEmpty(),
        isFavorite = this.isFavorite ?: false,
        salary = this.salary?.toUI() ?: VacancySalaryUI.Default,
        schedules = this.schedules.orEmpty(),
        appliedNumber = this.appliedNumber ?: 0,
        description = this.description.orEmpty(),
        responsibilities = this.responsibilities.orEmpty(),
        questions = this.questions.orEmpty()
    )

}

fun VacanciesAddressResponse.toUI(): VacancyAddressUI {
    return VacancyAddressUI(
        town = this.town.orEmpty(),
        street = this.street.orEmpty(),
        house = this.house.orEmpty()
    )
}

fun VacanciesExperienceResponse.toUI(): VacancyExperienceUI {
    return VacancyExperienceUI(previewText = this.previewText.orEmpty(), text = this.text.orEmpty())
}

fun VacanciesSalaryResponse.toUI(): VacancySalaryUI {
    return VacancySalaryUI(full = this.full.orEmpty())
}
