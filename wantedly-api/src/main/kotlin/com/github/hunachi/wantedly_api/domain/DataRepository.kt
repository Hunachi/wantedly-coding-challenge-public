package com.github.hunachi.wantedly_api.domain

import com.github.hunachi.wantedly_api.domain.data.Data
import io.reactivex.Single

interface DataRepository {
    
    fun data(
        keyWord: String,
        page: Long
    ): Single<List<Data>>
}