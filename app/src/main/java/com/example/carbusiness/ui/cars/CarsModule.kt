package com.example.carbusiness.ui.cars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.carbusiness.data.repository.CarsRepository
import com.example.carbusiness.di.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class CarsModule {

    @Provides
    @FragmentScope
    internal fun provideCarsViewModelFactory(repository: CarsRepository) = CarsViewModelFactory(repository)
}

class CarsViewModelFactory(private val repository: CarsRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = CarsViewModel(repository) as T
}