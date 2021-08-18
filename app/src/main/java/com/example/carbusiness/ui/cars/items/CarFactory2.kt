package com.example.carbusiness.ui.cars.items

import com.example.carbusiness.CarItemBinding2
import com.example.carbusiness.R
import com.example.carbusiness.base.adapter.CarBusinessAdapter
import com.example.carbusiness.base.adapter.ListItemFactory

class CarFactory2 : ListItemFactory<CarItem2, CarItemBinding2>(R.layout.item_car_2) {

    override fun onBindViewHolder(holder: CarBusinessAdapter.ViewHolder, item: CarItem2) {
        super.onBindViewHolder(holder, item)

        (holder.binding as CarItemBinding2).apply {
            brandTextView.text = item.brand
            yearTextView.text = "${item.year}"
        }
    }
}