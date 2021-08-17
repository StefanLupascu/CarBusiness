package com.example.carbusiness.data.repository

import com.example.carbusiness.data.model.Car
import com.example.carbusiness.data.model.CarRequest
import com.example.carbusiness.utils.Result

interface CarsRepository {

    suspend fun getCars(): Result<List<Car>>

    suspend fun createCar(car: CarRequest): Result<String>
}