package com.example.carbusiness.ui.cars

import android.os.Bundle
import android.view.View
import com.example.carbusiness.CarsBinding
import com.example.carbusiness.R
import com.example.carbusiness.base.adapter.CarBusinessAdapter
import com.example.carbusiness.base.fragment.CarBusinessViewModelFragment
import com.example.carbusiness.ui.cars.adapter.CarsAdapter
import com.example.carbusiness.ui.cars.items.CarFactory
import com.example.carbusiness.ui.cars.items.CarFactory2
import com.example.carbusiness.ui.cars.items.CarFactory3
import com.example.carbusiness.ui.main.MainActivity
import com.example.carbusiness.utils.observeNonNull
import com.example.carbusiness.utils.showToast

class CarsFragment: CarBusinessViewModelFragment<CarsBinding, CarsViewModel, CarsViewModelFactory>(R.layout.fragment_cars, CarsViewModel::class) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val adapter = CarsAdapter(
//            onCarClicked = { id ->
//                (activity as MainActivity).navigateToCarDetails(id)
//            }
//        )
        val adapter = CarBusinessAdapter(
            CarFactory(onItemClicked = { id ->
                showToast(requireContext(), "Car $id")
            }),
            CarFactory2(),
            CarFactory3()
        )

        binding.carsList.adapter = adapter

        viewModel.carsLiveData.observeNonNull(this) {
            binding.progressBar.visibility = View.GONE
            adapter.submitList(it)
        }
        viewModel.errorLiveData.observeNonNull(this) {
            showToast(requireContext(), it)
        }
    }

    override fun onResume() {
        super.onResume()

        binding.progressBar.visibility = View.VISIBLE
        viewModel.getCars()
    }

    companion object {
        fun newInstance() = CarsFragment()
    }
}