package com.github.hunachi.wantedly_api.domain.data.company

import com.github.hunachi.common.ddd.Entity
import com.github.hunachi.common.url.Url
import com.github.hunachi.common.url.UrlImage

data class Company(
    override val id: CompanyId,
    val name: String,
    val founder: String,
    val foundedOn: String,
    val address: String,
    val url: Url,
    val avatar: Url
) : Entity<CompanyId>(id)