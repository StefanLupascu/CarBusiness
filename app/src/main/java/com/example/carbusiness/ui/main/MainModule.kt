package com.example.carbusiness.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.carbusiness.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @ActivityScope
    internal fun provideMainViewModelFactory() = MainViewModelFactory()
}

class MainViewModelFactory(): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel() as T
}