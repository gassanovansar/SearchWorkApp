package com.example.models.mappers

import com.example.models.data.OfferButtonResponse
import com.example.models.data.OfferResponse
import com.example.models.domain.Icon
import com.example.models.domain.OfferButtonUI
import com.example.models.domain.OfferUI

fun OfferResponse.toUI(): OfferUI {

    return OfferUI(
        id = this.id.orEmpty(),
        title = this.title.orEmpty(),
        button = this.button?.toUI() ?: OfferButtonUI.Default,
        icon = Icon.entries.find { it.id == this.id } ?: Icon.Empty,
        link = this.link.orEmpty()
    )
}

//TODO FIX IMPORTS
fun OfferButtonResponse.toUI(): OfferButtonUI {
    return OfferButtonUI(title = this.text.orEmpty())
}