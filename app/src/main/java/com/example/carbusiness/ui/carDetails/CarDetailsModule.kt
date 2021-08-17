package com.example.carbusiness.ui.carDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.carbusiness.data.repository.CarsRepository
import com.example.carbusiness.di.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class CarDetailsModule {

    @Provides
    @FragmentScope
    internal fun provideCarDetailsViewModelFactory(repository: CarsRepository) = CarDetailsViewModelFactory(repository)
}

class CarDetailsViewModelFactory(private val repository: CarsRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = CarDetailsViewModel(repository) as T
}