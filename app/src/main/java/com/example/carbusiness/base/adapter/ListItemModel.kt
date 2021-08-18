package com.example.carbusiness.base.adapter

import androidx.annotation.LayoutRes

abstract class ListItemModel(@LayoutRes val layoutRes: Int) {

    abstract val id: String

    abstract override fun equals(other: Any?): Boolean

    abstract override fun hashCode(): Int
}