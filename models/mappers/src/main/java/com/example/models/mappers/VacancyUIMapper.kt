package com.example.models.mappers

import com.example.models.data.VacanciesAddressResponse
import com.example.models.data.VacanciesExperienceResponse
import com.example.models.data.VacanciesResponse
import com.example.models.data.VacanciesSalaryResponse
import com.example.models.domain.VacancyUI

fun VacanciesResponse.toUI(): VacancyUI {
    return VacancyUI(
        id = this.id.orEmpty(),
        lookingNumber = this.lookingNumber ?: 0,
        title = this.title.orEmpty(),
        address = this.address?.toUI() ?: com.example.models.domain.VacancyAddressUI.Default,
        company = this.company.orEmpty(),
        experience = this.experience?.toUI() ?: com.example.models.domain.VacancyExperienceUI.Default,
        publishedDate = this.publishedDate.orEmpty(),
        isFavorite = this.isFavorite ?: false,
        salary = this.salary?.toUI() ?: com.example.models.domain.VacancySalaryUI.Default,
        schedules = this.schedules.orEmpty(),
        appliedNumber = this.appliedNumber ?: 0,
        description = this.description.orEmpty(),
        responsibilities = this.responsibilities.orEmpty(),
        questions = this.questions.orEmpty()
    )

}

fun VacanciesAddressResponse.toUI(): com.example.models.domain.VacancyAddressUI {
    return com.example.models.domain.VacancyAddressUI(
        town = this.town.orEmpty(),
        street = this.street.orEmpty(),
        house = this.house.orEmpty()
    )
}

fun VacanciesExperienceResponse.toUI(): com.example.models.domain.VacancyExperienceUI {
    return com.example.models.domain.VacancyExperienceUI(
        previewText = this.previewText.orEmpty(),
        text = this.text.orEmpty()
    )
}

fun VacanciesSalaryResponse.toUI(): com.example.models.domain.VacancySalaryUI {
    return com.example.models.domain.VacancySalaryUI(full = this.full.orEmpty())
}
