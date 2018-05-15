package com.github.hunachi.wantedly_api.domain.data

import com.github.hunachi.common.ddd.Entity
import com.github.hunachi.common.url.Url
import com.github.hunachi.common.url.UrlImage
import com.github.hunachi.wantedly_api.domain.data.company.Company
import com.github.hunachi.wantedly_api.domain.data.leader.Leader
import com.github.hunachi.wantedly_api.domain.data.staff.Staff

data class Data(
    override val id: DataId,
    val title: String,
    val publishedAt: String,
    val supportCount: Long,
    val candidateCount: Long,
    val location: String,
    val description: String,
    val urlImage: Url,
    val company: Company,
    val staffCount: Long,
    val staffs: List<Staff>,
    val leader: Leader,
    val canSupport: Boolean,
    val canApply: Boolean
) : Entity<DataId>(id)