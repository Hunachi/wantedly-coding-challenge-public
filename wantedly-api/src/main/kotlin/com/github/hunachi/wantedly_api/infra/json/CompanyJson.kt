package com.github.hunachi.wantedly_api.infra.json

import com.squareup.moshi.Json
import io.reactivex.annotations.Nullable
import retrofit2.http.Url
import se.ansman.kotshi.JsonDefaultValue
import se.ansman.kotshi.JsonDefaultValueDouble
import se.ansman.kotshi.JsonDefaultValueString
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class CompanyJson(
    val id: Long,
    @JsonDefaultValueString("")
    val name: String,
    @JsonDefaultValueString("")
    val founder: String,
    @Json(name = "founded_on")
    @JsonDefaultValueString("")
    val foundedOn: String,
    @Json(name = "address_prefix")
    @JsonDefaultValueString("")
    val addressPrefix: String,
    @Json(name = "address_suffix")
    @JsonDefaultValueString("")
    val addressSuffix: String,
    @JsonDefaultValueDouble(-1.0)
    val latitude: Double,
    @JsonDefaultValueDouble(-1.0)
    val longitude: Double,
    @JsonDefaultValueString("")
    val url: String,
    @JsonDefaultValue
    val avatar: AvatarJson
) {
    companion object {
        @JvmStatic
        @JsonDefaultValue
        val defaltAvatar = AvatarJson("")
    }
}