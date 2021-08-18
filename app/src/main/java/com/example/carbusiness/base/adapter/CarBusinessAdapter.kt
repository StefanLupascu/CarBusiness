package com.example.carbusiness.base.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.lang.RuntimeException

class CarBusinessAdapter(private vararg val listItemFactories: ListItemFactory<*, *>) :
    ListAdapter<ListItemModel, CarBusinessAdapter.ViewHolder>(object : DiffUtil.ItemCallback<ListItemModel>() {
        override fun areItemsTheSame(oldItem: ListItemModel, newItem: ListItemModel) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ListItemModel, newItem: ListItemModel) = oldItem == newItem
    }) {

    @Suppress("UNCHECKED_CAST")
    private fun getItemFactories(): Array<ListItemFactory<ListItemModel, ViewDataBinding>> =
        listItemFactories as Array<ListItemFactory<ListItemModel, ViewDataBinding>>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        getItemFactories().firstOrNull { it.layoutRes == viewType }?.onCreateViewHolder(parent)
            ?: throw MissingFactoryException("Item type: $viewType not supported")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        val layoutRes = item.layoutRes
        val factory = getItemFactories().firstOrNull { it.layoutRes == layoutRes }
            ?: throw MissingFactoryException("Item type: $layoutRes not supported")
        factory.onBindViewHolder(holder, item)
    }

    override fun getItemViewType(position: Int) = getItem(position).layoutRes

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    class MissingFactoryException(message: String) : RuntimeException(message)
}