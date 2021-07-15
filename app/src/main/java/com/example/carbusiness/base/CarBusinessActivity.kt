package com.example.carbusiness.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class CarBusinessActivity<BINDING: ViewDataBinding>(@LayoutRes private val layoutResource: Int) : DaggerAppCompatActivity() {

    protected lateinit var binding: BINDING

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        DataBindingUtil.setContentView<BINDING>(this, layoutResource).also {
            it.lifecycleOwner = this
            binding = it
        }
    }
}