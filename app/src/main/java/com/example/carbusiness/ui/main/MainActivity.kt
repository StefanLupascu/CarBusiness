package com.example.carbusiness.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.carbusiness.MainBinding
import com.example.carbusiness.R
import com.example.carbusiness.base.activity.CarBusinessViewModelActivity
import com.example.carbusiness.ui.add.AddCarFragment
import com.example.carbusiness.ui.carDetails.CarDetailsFragment
import com.example.carbusiness.ui.cars.CarsFragment

class MainActivity : CarBusinessViewModelActivity<MainBinding, MainViewModel, MainViewModelFactory>(
    R.layout.activity_main, MainViewModel::class) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigateToCars()

        binding.apply {
            addButton.setOnClickListener { navigateToAddCar() }
            backButton.setOnClickListener { navigateToCars() }
        }
    }

    override fun onBackPressed() {
        navigateToCars()
    }

    // TODO: Save id into parentViewModel
    fun navigateToCarDetails(id: Long) {
        updateToolbar(isMainScreen = false)
        switchFragment(CarDetailsFragment.newInstance())
    }

    private fun navigateToCars() {
        updateToolbar(toolbarTitleText = resources.getString(R.string.available_cars))
        switchFragment(CarsFragment.newInstance())
    }

    private fun navigateToAddCar() {
        updateToolbar(isMainScreen = false)
        switchFragment(AddCarFragment.newInstance())
    }

    private fun updateToolbar(toolbarTitleText: String = "", isMainScreen: Boolean = true) {
        binding.apply {
            toolbarTitle.text = toolbarTitleText
            addButton.visibility = if (isMainScreen) View.VISIBLE else View.GONE
            backButton.visibility = if (isMainScreen) View.GONE else View.VISIBLE
        }
    }

    private fun switchFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.apply {
            replace(binding.fragmentContainer.id, fragment)
            commit()
        }
    }
}