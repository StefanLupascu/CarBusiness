package com.example.carbusiness.ui.cars.items

import com.example.carbusiness.R
import com.example.carbusiness.base.adapter.ListItemModel

data class CarItem2(
    private val itemId: String,
    val brand: String,
    val year: Int
) : ListItemModel(R.layout.item_car_2) {

    override val id: String get() = itemId
}