package com.example.carbusiness.ui.cars.items

import com.example.carbusiness.R
import com.example.carbusiness.base.adapter.ListItemModel

data class CarItem(
    private val itemId: String,
    val brand: String,
    val year: Int
) : ListItemModel(R.layout.item_car) {

    override val id: String get() = itemId
}