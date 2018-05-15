package com.github.hunachi.wantedly_api.infra.json

import com.squareup.moshi.Json
import io.reactivex.annotations.Nullable
import se.ansman.kotshi.JsonDefaultValueString
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class LeaderJson(
    @Nullable
    @Json(name = "name_ja")
    @JsonDefaultValueString("")
    val nameJa: String,
    @Nullable
    @Json(name = "name_en")
    @JsonDefaultValueString("")
    val nameEn: String,
    @Nullable
    @Json(name = "facebook_uid")
    @JsonDefaultValueString("")
    val facebookUid: String
)