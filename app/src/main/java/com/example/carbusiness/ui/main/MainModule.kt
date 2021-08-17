package com.example.carbusiness.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.carbusiness.data.repository.CarsRepository
import com.example.carbusiness.di.ActivityScope
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
class MainModule {

    @Provides
    @ActivityScope
    internal fun provideMainViewModelFactory(repository: CarsRepository) = MainViewModelFactory(repository)
}

class MainViewModelFactory(private val repository: CarsRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel(repository) as T
}