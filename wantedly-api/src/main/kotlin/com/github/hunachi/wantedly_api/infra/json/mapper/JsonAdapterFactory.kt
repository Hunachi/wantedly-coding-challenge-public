package com.github.hunachi.wantedly_api.infra.json.mapper

import com.squareup.moshi.JsonAdapter
import se.ansman.kotshi.KotshiJsonAdapterFactory

@KotshiJsonAdapterFactory
abstract class MyJsonAdapterFactory: JsonAdapter.Factory {
    companion object {
        val INSTANCE: MyJsonAdapterFactory = KotshiMyJsonAdapterFactory()
    }
}