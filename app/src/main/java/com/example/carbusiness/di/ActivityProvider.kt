package com.example.carbusiness.di

import com.example.carbusiness.ui.landing.LandingActivity
import com.example.carbusiness.ui.landing.LandingModule
import com.example.carbusiness.ui.main.MainActivity
import com.example.carbusiness.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityProvider {

    @ActivityScope
    @ContributesAndroidInjector(modules = [LandingModule::class])
    internal abstract fun provideLandingActivity(): LandingActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun provideMainActivity(): MainActivity
}