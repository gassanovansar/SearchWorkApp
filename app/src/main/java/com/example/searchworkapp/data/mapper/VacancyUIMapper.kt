package com.example.searchworkapp.data.mapper

import com.example.searchworkapp.data.model.VacanciesAddressResponse
import com.example.searchworkapp.data.model.VacanciesExperienceResponse
import com.example.searchworkapp.data.model.VacanciesResponse
import com.example.searchworkapp.data.model.VacanciesSalaryResponse
import com.example.models.VacancyAddressUI
import com.example.models.VacancyExperienceUI
import com.example.models.VacancySalaryUI
import com.example.models.VacancyUI

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
