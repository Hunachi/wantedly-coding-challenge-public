package com.github.hunachi.wantedly_api.domain.data.company

import com.github.hunachi.common.url.Url
import com.github.hunachi.wantedly_api.infra.json.CompanyJson

internal fun CompanyJson.convertToCompany(): Company =
    Company(
        id = CompanyId(id),
        name = name,
        founder = founder,
        foundedOn = foundedOn.replace("-", "/"),
        address = "$addressPrefix/n$addressSuffix",
        url = Url(url),
        avatar = Url(avatar.imageUrl)
    )