package com.example.carbusiness.di

import android.app.Application
import android.content.Context
import com.example.carbusiness.CarBusinessApplication
import com.example.carbusiness.data.repository.CarsRepository
import com.example.carbusiness.data.repository.CarsRepositoryImpl
import com.example.carbusiness.data.service.CarsService
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    
    @Provides
    @ApplicationScope
    internal fun provideApplication(application: Application): CarBusinessApplication = 
        application as CarBusinessApplication
    
    @Provides
    @ApplicationScope
    internal fun provideContext(application: Application): Context = application
}