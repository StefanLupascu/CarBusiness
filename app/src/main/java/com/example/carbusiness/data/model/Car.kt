package com.example.carbusiness.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Car(
    val id: Long,
    val brand: CarBrand,
    val color: String,
    val horsePower: Int,
    val year: Int,
    val price: Int
)