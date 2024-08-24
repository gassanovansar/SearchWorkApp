package com.example.models.domain

enum class Icon(val id: String) {
    NearVacancies("near_vacancies"),
    LevelUpResume("level_up_resume"),
    TemporaryJob("temporary_job"),
    Empty("")
}

class OfferUI(
    val id: String,
    val title: String,
    val button: OfferButtonUI,
    val icon: Icon,
    val link: String
) {
    companion object {
        val Default =
            OfferUI(id = "", title = "", button = OfferButtonUI.Default, Icon.Empty, link = "")
    }
}

class OfferButtonUI(val title: String) {
    companion object {
        val Default = OfferButtonUI(title = "")
    }
}