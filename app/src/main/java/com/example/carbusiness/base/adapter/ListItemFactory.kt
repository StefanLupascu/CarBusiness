package com.example.carbusiness.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class ListItemFactory<ITEM_MODEL : ListItemModel, BINDING : ViewDataBinding>
    (@LayoutRes val layoutRes: Int) {

    @CallSuper
    fun onCreateViewHolder(parent: ViewGroup): CarBusinessAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<BINDING>(
            LayoutInflater.from(parent.context), layoutRes, parent, false
        )
        val viewHolder = CarBusinessAdapter.ViewHolder(binding)
        initializeViewHolder(binding)
        return viewHolder
    }

    protected open fun initializeViewHolder(binding: BINDING) = Unit

    open fun onBindViewHolder(holder: CarBusinessAdapter.ViewHolder, item: ITEM_MODEL) {
        holder.binding.apply {
            setVariable(1, item)
            executePendingBindings()
        }
    }
}