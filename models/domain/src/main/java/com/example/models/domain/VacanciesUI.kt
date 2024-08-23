package com.example.models.domain


data class VacancyUI(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: VacancyAddressUI,
    val company: String,
    val experience: VacancyExperienceUI,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: VacancySalaryUI,
    val schedules: List<String>,
    val appliedNumber: Int,
    val description: String,
    val responsibilities: String,
    val questions: List<String>
) {
    companion object {
        val Default = VacancyUI(
            id = "",
            lookingNumber = 0,
            title = "",
            address = VacancyAddressUI.Default,
            company = "",
            experience = VacancyExperienceUI.Default,
            publishedDate = "",
            isFavorite = false,
            salary = VacancySalaryUI.Default,
            schedules = emptyList(),
            appliedNumber = 0,
            description = "",
            responsibilities = "",
            questions = emptyList()

        )
    }
}


class VacancyAddressUI(
    val town: String,
    val street: String,
    val house: String
) {
    companion object {
        val Default = VacancyAddressUI(town = "", street = "", house = "")
    }
}


class VacancyExperienceUI(
    val previewText: String,
    val text: String,
) {
    companion object {
        val Default = VacancyExperienceUI(previewText = "", text = "")
    }
}


class VacancySalaryUI(
    val full: String,
) {
    companion object {
        val Default = VacancySalaryUI(full = "")
    }
}