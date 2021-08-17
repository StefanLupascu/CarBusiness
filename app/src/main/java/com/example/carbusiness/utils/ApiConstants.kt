package com.example.carbusiness.utils

object ApiConstants {

    const val BASE_URL = "http://192.168.0.129:9090/"

    object CarsApi {
        const val getCars = "cars/all"
        const val car = "cars/{id}"
    }

    object AuthenticationApi {
        const val authenticate = "users/authenticate"
    }
}