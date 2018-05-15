package com.github.hunachi.wantedly_api.infra.json

import com.squareup.moshi.Json
import io.reactivex.annotations.Nullable
import se.ansman.kotshi.*

@JsonSerializable
data class DataJson(
    val id: Long,
    @JsonDefaultValueString("")
    val title: String,
    @Json(name = "published_at")
    @JsonDefaultValueString("")
    val publishedAt: String,
    @Json(name = "support_count")
    @JsonDefaultValueLong(-1)
    val supportCount: Long,
    @Json(name = "candidate_count")
    @JsonDefaultValueLong(-1)
    val candidateCount: Long,
    @JsonDefaultValueString("")
    val location: String,
    @Json(name = "location_suffix")
    @JsonDefaultValueString("")
    val locationSuffix: String,
    @JsonDefaultValueString("")
    val description: String,
    @JsonDefaultValue
    val image: ImageJson,
    @Json(name = "use_webview")
    @JsonDefaultValueBoolean(false)
    val useWebview: Boolean,
    val company: CompanyJson,
    @Json(name = "staffings_count")
    @JsonDefaultValueLong(-1)
    val staffingsCount: Long,
    @JsonDefaultValue
    val staffings: List<StaffJson>,
    @JsonDefaultValue
    val leader: LeaderJson,
    @Json(name = "can_support")
    @JsonDefaultValueBoolean(false)
    val canSupport: Boolean,
    @Json(name = "can_apply")
    @JsonDefaultValueBoolean(false)
    val canApply: Boolean
) {
    companion object {
        @JvmStatic
        @JsonDefaultValue
        val defaultList = listOf<StaffJson>()
        
        @JvmStatic
        @JsonDefaultValue
        val defaultLeader = LeaderJson(
            nameJa = "",
            nameEn = "",
            facebookUid = ""
        )
        
        @JvmStatic
        @JsonDefaultValue
        val defaultImage = ImageJson("")
    }
}