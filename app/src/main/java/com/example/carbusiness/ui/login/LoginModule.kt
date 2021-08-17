package com.example.carbusiness.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.carbusiness.data.service.AuthenticationService
import com.example.carbusiness.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    @ActivityScope
    internal fun provideLoginViewModelFactory(authenticationService: AuthenticationService) = LoginViewModelFactory(authenticationService)
}

class LoginViewModelFactory(private val authenticationService: AuthenticationService): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = LoginViewModel(authenticationService) as T
}