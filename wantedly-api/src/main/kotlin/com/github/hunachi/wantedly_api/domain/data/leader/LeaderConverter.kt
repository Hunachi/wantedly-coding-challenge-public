package com.github.hunachi.wantedly_api.domain.data.leader

import com.github.hunachi.wantedly_api.infra.json.LeaderJson

internal fun LeaderJson.converterToLeader(): Leader =
    Leader(nameJp = nameJa, nameEn = nameEn)