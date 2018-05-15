package com.github.hunachi.wantedly_coding_challenge_android.di

import com.github.hunachi.wantedly_coding_challenge_android.ui.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class
    ]
)
internal interface AppComponent {
    
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder
        
        fun build(): AppComponent
    }
    
    fun inject(instance: MyApplication)
}