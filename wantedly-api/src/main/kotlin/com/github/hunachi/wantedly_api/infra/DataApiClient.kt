package com.github.hunachi.wantedly_api.infra

import com.github.hunachi.wantedly_api.infra.json.ResponceData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DataApiClient {
    
    @GET("v1/projects")
    fun getData(
        @Query("q") query: String,
        @Query("page") page: Long
    ): Single<ResponceData>
}