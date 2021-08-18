package com.example.carbusiness.ui.cars.items

import com.example.carbusiness.CarItemBinding3
import com.example.carbusiness.R
import com.example.carbusiness.base.adapter.CarBusinessAdapter
import com.example.carbusiness.base.adapter.ListItemFactory

class CarFactory3 : ListItemFactory<CarItem3, CarItemBinding3>(R.layout.item_car_3) {

    override fun onBindViewHolder(holder: CarBusinessAdapter.ViewHolder, item: CarItem3) {
        super.onBindViewHolder(holder, item)

        (holder.binding as CarItemBinding3).apply {
            brandTextView.text = item.brand
            yearTextView.text = "${item.year}"
        }
    }
}