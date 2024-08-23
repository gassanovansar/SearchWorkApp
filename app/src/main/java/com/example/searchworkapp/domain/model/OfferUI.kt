package com.example.searchworkapp.domain.model

class OfferUI(
    val id: String,
    val title: String,
    val button: OfferButtonUI,
    val link: String
) {
    companion object{
        val Default = OfferUI(id = "", title = "", button = OfferButtonUI.Default, link = "")
    }
}

class OfferButtonUI(val title: String){
    companion object{
        val Default = OfferButtonUI(title = "")
    }
}