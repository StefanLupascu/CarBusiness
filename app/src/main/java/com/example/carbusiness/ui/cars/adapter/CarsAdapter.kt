package com.example.carbusiness.ui.cars.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.carbusiness.CarItemBinding
import com.example.carbusiness.R
import com.example.carbusiness.data.model.Car

class CarsAdapter(private val onCarClicked: (id: Long) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var cars: MutableList<Car> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CarViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_car, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val car = cars[position]
        (holder as CarViewHolder).apply {
            bind(car)
            itemView.setOnClickListener { onCarClicked(car.id) }
        }
    }

    override fun getItemCount() = cars.size

    fun submitList(list: List<Car>) {
        cars = mutableListOf<Car>().apply {
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class CarViewHolder(val binding: CarItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(car: Car) {
            binding.apply {
                brandTextView.text = car.brand.brandText
                yearTextView.text = "${car.year}"
            }
        }
    }
}