package com.example.carbusiness.ui.cars

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carbusiness.data.model.Car
import com.example.carbusiness.data.repository.CarsRepository
import com.example.carbusiness.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CarsViewModel @Inject constructor(private val repository: CarsRepository): ViewModel() {

    private val _carsLiveData = MutableLiveData<List<Car>>()
    val carsLiveData: LiveData<List<Car>> get() = _carsLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    fun getCars() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getCars()) {
                is Result.Success -> {
                    _carsLiveData.postValue(result.value)
                }
                else -> {
                    _errorLiveData.postValue("Error")
                }
            }
        }
    }
}