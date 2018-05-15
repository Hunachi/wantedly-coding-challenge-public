package com.github.hunachi.wantedly_api.domain.data

import com.github.hunachi.common.url.Url
import com.github.hunachi.wantedly_api.domain.data.company.convertToCompany
import com.github.hunachi.wantedly_api.domain.data.leader.converterToLeader
import com.github.hunachi.wantedly_api.domain.data.staff.converterToStaff
import com.github.hunachi.wantedly_api.infra.json.DataJson

internal fun DataJson.converterToData(): Data =
    Data(
        id = DataId(id),
        title = title,
        publishedAt = publishedAt.replace("-", "/"),
        supportCount = supportCount,
        candidateCount = candidateCount,
        location = "$location/n$locationSuffix",
        description = description,
        urlImage = Url(image.imageUrl),
        company = company.convertToCompany(),
        staffCount = staffingsCount,
        staffs = staffings.map { it.converterToStaff() },
        leader = leader.converterToLeader(),
        canApply = canApply,
        canSupport = canSupport
    )
