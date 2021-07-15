package com.example.carbusiness.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment

abstract class CarBusinessFragment<BINDING: ViewDataBinding>(@LayoutRes private val layoutRes: Int) : DaggerFragment() {

    protected lateinit var binding: BINDING

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        DataBindingUtil.inflate<BINDING>(inflater, layoutRes, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            binding = this
        }.root
}