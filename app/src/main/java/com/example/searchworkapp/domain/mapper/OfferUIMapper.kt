package com.example.searchworkapp.domain.mapper

import com.example.searchworkapp.data.source.OfferButtonResponse
import com.example.searchworkapp.data.source.OfferResponse
import com.example.searchworkapp.domain.model.OfferButtonUI
import com.example.searchworkapp.domain.model.OfferUI

fun OfferResponse.toUI(): OfferUI {

    return OfferUI(
        id = this.id.orEmpty(),
        title = this.title.orEmpty(),
        button = this.button?.toUI() ?: OfferButtonUI.Default,
        link = this.link.orEmpty()
    )
}

fun OfferButtonResponse.toUI(): OfferButtonUI {
    return OfferButtonUI(title = this.text.orEmpty())
}