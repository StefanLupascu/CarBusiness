package com.example.carbusiness.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.carbusiness.data.repository.CarsRepository
import com.example.carbusiness.di.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class AddCarModule {

    @Provides
    @FragmentScope
    internal fun provideAddCarViewModelFactory(repository: CarsRepository) = AddCarViewModelFactory(repository)
}

class AddCarViewModelFactory(private val repository: CarsRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = AddCarViewModel(repository) as T
}