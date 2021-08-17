package com.example.carbusiness.utils

open class EventWrapper<out T>(private val content: T) {

    var consumed = false
        private set

    fun peek(): T = content

    fun consume(): T? {
        return if (consumed) {
            null
        } else {
            consumed = true
            content
        }
    }
}