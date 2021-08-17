package com.example.carbusiness.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carbusiness.data.model.CarBrand
import com.example.carbusiness.data.model.CarRequest
import com.example.carbusiness.data.repository.CarsRepository
import com.example.carbusiness.utils.BaseEvent
import com.example.carbusiness.utils.EventWrapper
import com.example.carbusiness.utils.Result
import com.example.carbusiness.utils.wrap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddCarViewModel @Inject constructor(private val repository: CarsRepository): ViewModel() {

    private val _event = MutableLiveData<EventWrapper<Event>>()
    val event: LiveData<EventWrapper<Event>> get() = _event

    fun createCar(
        brand: CarBrand,
        color: String,
        horsePower: Int,
        year: Int,
        price: Int
    ) {
        val carRequest = CarRequest(brand, color, horsePower, year, price)
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.createCar(carRequest)) {
                is Result.Success -> {
                    _event.postValue(Event.Success(result.value).wrap())
                }
                else -> {
                    _event.postValue(Event.Failure.wrap())
                }
            }
        }
    }

    sealed class Event: BaseEvent {
        class Success(val message: String): Event()
        object Failure: Event()
    }
}