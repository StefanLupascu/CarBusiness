package com.example.carbusiness.data.repository

import com.example.carbusiness.data.model.CarRequest
import com.example.carbusiness.data.service.CarsService
import com.example.carbusiness.utils.wrapIntoResult
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(private val service: CarsService): CarsRepository {

    override suspend fun getCars() = wrapIntoResult { service.getCars() }

    override suspend fun createCar(car: CarRequest) = wrapIntoResult { service.createCar(car) }
}