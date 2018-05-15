package com.github.hunachi.wantedly_coding_challenge_android.ui

import android.app.Activity
import android.app.Application
import com.github.hunachi.wantedly_coding_challenge_android.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MyApplication : Application(), HasActivityInjector {
    
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    
    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
    
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}