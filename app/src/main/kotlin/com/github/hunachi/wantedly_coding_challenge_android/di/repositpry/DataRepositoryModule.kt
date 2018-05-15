package com.github.hunachi.wantedly_coding_challenge_android.di.repositpry

import com.github.hunachi.wantedly_api.domain.DataRepository
import com.github.hunachi.wantedly_api.domain.DataRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataRepositoryModule {
    
    @Provides
    fun providedDataRepository(
        repositoryImpl: DataRepositoryImpl
    ): DataRepository = repositoryImpl
}