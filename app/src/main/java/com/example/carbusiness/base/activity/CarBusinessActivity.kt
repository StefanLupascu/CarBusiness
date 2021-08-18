package com.example.carbusiness.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class CarBusinessActivity<BINDING: ViewDataBinding>(@LayoutRes private val layoutResource: Int) : DaggerAppCompatActivity() {

    protected lateinit var binding: BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<BINDING>(this, layoutResource).also {
            it.lifecycleOwner = this
            binding = it
        }
    }
}