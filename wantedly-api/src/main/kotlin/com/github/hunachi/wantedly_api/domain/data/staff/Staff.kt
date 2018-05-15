package com.github.hunachi.wantedly_api.domain.data.staff

import com.github.hunachi.common.ddd.Entity

data class Staff(
    override val id: StaffId,
    val isLeader: Boolean,
    val name: String,
    val description: String
): Entity<StaffId>(id)