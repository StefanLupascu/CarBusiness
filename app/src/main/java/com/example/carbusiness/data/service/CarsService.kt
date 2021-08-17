package com.example.carbusiness.data.service

import com.example.carbusiness.data.model.Car
import com.example.carbusiness.data.model.CarRequest
import com.example.carbusiness.utils.ApiConstants
import com.example.carbusiness.utils.Result
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CarsService {

    @GET(ApiConstants.CarsApi.getCars)
    suspend fun getCars(): List<Car>

    @POST(ApiConstants.CarsApi.car)
    suspend fun createCar(@Body car: CarRequest): String
}