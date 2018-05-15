package com.github.hunachi.wantedly_api.infra.json

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class ResponceData(
    val data: List<DataJson>
)