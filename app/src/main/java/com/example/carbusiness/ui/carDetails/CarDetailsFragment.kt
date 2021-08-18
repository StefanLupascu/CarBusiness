package com.example.carbusiness.ui.carDetails

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.carbusiness.CarDetailsBinding
import com.example.carbusiness.R
import com.example.carbusiness.base.fragment.CarBusinessViewModelFragment

class CarDetailsFragment:
    CarBusinessViewModelFragment<CarDetailsBinding, CarDetailsViewModel, CarDetailsViewModelFactory>(
        R.layout.fragment_car_details,
        CarDetailsViewModel::class
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("STEFAN", "CarDetails works")
    }

    companion object {
        fun newInstance() = CarDetailsFragment()
    }
}