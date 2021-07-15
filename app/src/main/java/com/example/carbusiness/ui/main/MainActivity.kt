package com.example.carbusiness.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import com.example.carbusiness.MainBinding
import com.example.carbusiness.R
import com.example.carbusiness.base.CarBusinessViewModelActivity

class MainActivity : CarBusinessViewModelActivity<MainBinding, MainViewModel, MainViewModelFactory>(
    R.layout.activity_main, MainViewModel::class) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding.textView.text = "Works"
    }
}