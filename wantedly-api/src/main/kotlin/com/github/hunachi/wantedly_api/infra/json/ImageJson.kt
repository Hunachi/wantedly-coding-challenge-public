package com.github.hunachi.wantedly_api.infra.json

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonDefaultValueLong
import se.ansman.kotshi.JsonDefaultValueString
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class ImageJson(
    @Json(name = "i_320_131")
    @JsonDefaultValueString("")
    val imageUrl: String
)