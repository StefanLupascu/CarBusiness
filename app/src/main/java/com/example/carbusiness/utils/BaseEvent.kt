package com.example.carbusiness.utils

interface BaseEvent

fun <EVENT: BaseEvent> EVENT.wrap() = EventWrapper(this)