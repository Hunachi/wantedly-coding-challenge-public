package com.github.hunachi.wantedly_api.infra.json

import com.squareup.moshi.Json
import io.reactivex.annotations.Nullable
import se.ansman.kotshi.JsonDefaultValueBoolean
import se.ansman.kotshi.JsonDefaultValueLong
import se.ansman.kotshi.JsonDefaultValueString
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class StaffJson(
    @Json(name = "user_id")
    val id: Long,
    @Json(name = "is_leader")
    @JsonDefaultValueBoolean(false)
    val isLeader: Boolean,
    @JsonDefaultValueString("")
    val name: String,
    @Json(name = "facebook_uid")
    @JsonDefaultValueString("")
    val facebookUid: String,
    @JsonDefaultValueString("")
    val description: String
)