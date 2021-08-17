package com.example.carbusiness.ui.add

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.carbusiness.AddCarBinding
import com.example.carbusiness.R
import com.example.carbusiness.base.CarBusinessViewModelFragment

class AddCarFragment:
    CarBusinessViewModelFragment<AddCarBinding, AddCarViewModel, AddCarViewModelFactory>(R.layout.fragment_add_car, AddCarViewModel::class) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object {
        fun newInstance() = AddCarFragment()
    }
}