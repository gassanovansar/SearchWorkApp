package com.example.searchworkapp.data.model

import kotlinx.serialization.Serializable

@Serializable
class OfferResponse(
    val id: String?,
    val title: String?,
    val button: OfferButtonResponse?,
    val link: String?
)

@Serializable
class OfferButtonResponse(val text: String?)
