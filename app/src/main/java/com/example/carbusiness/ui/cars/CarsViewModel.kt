package com.example.carbusiness.ui.cars

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carbusiness.base.adapter.ListItemModel
import com.example.carbusiness.data.model.Car
import com.example.carbusiness.data.model.CarBrand
import com.example.carbusiness.data.repository.CarsRepository
import com.example.carbusiness.ui.cars.items.CarItem
import com.example.carbusiness.ui.cars.items.CarItem2
import com.example.carbusiness.ui.cars.items.CarItem3
import com.example.carbusiness.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CarsViewModel @Inject constructor(private val repository: CarsRepository): ViewModel() {

    private val _carsLiveData = MutableLiveData<List<ListItemModel>>()
    val carsLiveData: LiveData<List<ListItemModel>> get() = _carsLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    fun getCars() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getCars()) {
                is Result.Success -> {
                    handleCars(result.value)
                }
                else -> {
                    _errorLiveData.postValue("Error")
                }
            }
        }
    }

    private fun handleCars(cars: List<Car>) {
        val carListModels = cars.map {
            when (it.brand) {
                CarBrand.AUDI -> CarItem(it.id.toString(), it.brand.brandText, it.year)
                CarBrand.BMW -> CarItem2(it.id.toString(), it.brand.brandText, it.year)
                else -> CarItem3(it.id.toString(), it.brand.brandText, it.year)
            }
        }

        _carsLiveData.postValue(carListModels)
    }
}