package com.github.hunachi.wantedly_api.infra.json

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonDefaultValueString
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class AvatarJson(
    @Json(name = "s_50")
    @JsonDefaultValueString("")
    val imageUrl: String
)