package com.github.hunachi.wantedly_coding_challenge_android.domain.detail

import com.github.hunachi.wantedly_api.domain.data.Data

internal fun Data.convertDitailData() =
        DetailData(
            title = title,
            companyAvatar = company.avatar.value,
            companyName = company.name,
            urlImage = urlImage.value,
            description = description
        )