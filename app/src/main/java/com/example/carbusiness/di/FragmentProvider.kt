package com.example.carbusiness.di

import com.example.carbusiness.ui.add.AddCarFragment
import com.example.carbusiness.ui.add.AddCarModule
import com.example.carbusiness.ui.carDetails.CarDetailsFragment
import com.example.carbusiness.ui.carDetails.CarDetailsModule
import com.example.carbusiness.ui.cars.CarsFragment
import com.example.carbusiness.ui.cars.CarsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {

    @FragmentScope
    @ContributesAndroidInjector(modules = [AddCarModule::class])
    internal abstract fun provideAddCarFragment(): AddCarFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [CarsModule::class])
    internal abstract fun provideCarsFragment(): CarsFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [CarDetailsModule::class])
    internal abstract fun provideCarDetailsFragment(): CarDetailsFragment
}