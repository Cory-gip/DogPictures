package com.caren.dogpictures.network

import com.squareup.moshi.Json

/**
 * https://dog.ceo/api/breeds/image/random
 */
data class Dog(

    @Json(name = "message") val url: String?,

    val status: String?,

    // val preformattedHTML: String?,
)