package com.example.carbusiness.ui.cars.items

import com.example.carbusiness.CarItemBinding
import com.example.carbusiness.R
import com.example.carbusiness.base.adapter.CarBusinessAdapter
import com.example.carbusiness.base.adapter.ListItemFactory

class CarFactory(private val onItemClicked: (id: String) -> Unit) : ListItemFactory<CarItem, CarItemBinding>(R.layout.item_car) {

    override fun onBindViewHolder(holder: CarBusinessAdapter.ViewHolder, item: CarItem) {
        super.onBindViewHolder(holder, item)

        (holder.binding as CarItemBinding).apply {
            root.setOnClickListener { onItemClicked(item.id) }
            brandTextView.text = item.brand
            yearTextView.text = "${item.year}"
        }
    }
}