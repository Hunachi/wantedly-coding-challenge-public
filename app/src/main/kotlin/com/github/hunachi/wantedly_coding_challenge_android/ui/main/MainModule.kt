package com.github.hunachi.wantedly_coding_challenge_android.ui.main

import android.arch.lifecycle.ViewModel
import com.github.hunachi.wantedly_coding_challenge_android.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {
    
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
    
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainVieewModel(viewModel: MainViewModel): ViewModel
}