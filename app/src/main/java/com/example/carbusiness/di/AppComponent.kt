package com.example.carbusiness.di

import android.app.Application
import com.example.carbusiness.CarBusinessApplication
import com.example.carbusiness.data.service.ServiceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@ApplicationScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityProvider::class,
        FragmentProvider::class,
        ServiceModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(carBusinessApplication: CarBusinessApplication)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}