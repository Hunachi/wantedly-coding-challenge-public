package com.github.hunachi.wantedly_coding_challenge_android.di

import android.content.Context
import com.github.hunachi.wantedly_coding_challenge_android.di.repositpry.DataRepositoryModule
import com.github.hunachi.wantedly_coding_challenge_android.ui.main.MainModule
import com.github.hunachi.wantedly_coding_challenge_android.ui.MyApplication
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module(
    includes = [
        ViewModelModule::class,
        MainModule::class,
        DataRepositoryModule::class
    ]
)
internal class AppModule {
    
    @Provides
    internal fun providedContext(application: MyApplication): Context =
        application.applicationContext
    
    @Provides
    @Named("io")
    fun providedScheduler(): Scheduler = Schedulers.io()
    
    @Provides
    @Named("ui")
    fun providedUiScheduler() = AndroidSchedulers.mainThread()
}