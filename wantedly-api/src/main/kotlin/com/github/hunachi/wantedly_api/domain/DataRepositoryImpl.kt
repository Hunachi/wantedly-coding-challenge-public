package com.github.hunachi.wantedly_api.domain

import com.github.hunachi.wantedly_api.domain.data.Data
import com.github.hunachi.wantedly_api.domain.data.converterToData
import com.github.hunachi.wantedly_api.infra.DataApiClientFactory
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class DataRepositoryImpl @Inject constructor(
    @Named("io") private val scheduler: Scheduler
) : DataRepository {
    
    private val apiClient = DataApiClientFactory.apiClient
    
    override fun data(keyWord: String, page: Long): Single<List<Data>> =
        apiClient.getData(keyWord, page)
            .map { it.data.map { it.converterToData() } }
            .subscribeOn(scheduler)
}