package com.example.carbusiness.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class CarBusinessViewModelFragment<BINDING : ViewDataBinding, VM : ViewModel, VMF : ViewModelProvider.Factory>(
    @LayoutRes private val layoutRes: Int,
    vmKClass: KClass<VM>
) : CarBusinessFragment<BINDING>(layoutRes) {

    @Inject
    lateinit var viewModelFactory: VMF
    protected val viewModel: VM by ViewModelLazy(vmKClass, { viewModelStore }, { viewModelFactory })
}