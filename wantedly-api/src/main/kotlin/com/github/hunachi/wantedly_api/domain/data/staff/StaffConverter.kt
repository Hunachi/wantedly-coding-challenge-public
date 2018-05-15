package com.github.hunachi.wantedly_api.domain.data.staff

import com.github.hunachi.wantedly_api.infra.json.StaffJson

internal fun StaffJson.converterToStaff(): Staff =
    Staff(
        id = StaffId(id),
        isLeader = isLeader,
        name = name,
        description = description
    )