package com.github.hunachi.wantedly_api.infra

import com.github.hunachi.wantedly_api.infra.json.mapper.MyJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

internal object DataApiClientFactory {
    
    val apiClient: DataApiClient
    
    init {
        val kotshi by lazy {
            Moshi.Builder()
                .add(MyJsonAdapterFactory.INSTANCE)
                .build()
        }
        
        val httpClient = OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            })
        }
        
        val retrofit = Retrofit.Builder().baseUrl("https://www.wantedly.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(kotshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient.build())
            .build()
        
        apiClient = retrofit.create(DataApiClient::class.java)
    }
    
}