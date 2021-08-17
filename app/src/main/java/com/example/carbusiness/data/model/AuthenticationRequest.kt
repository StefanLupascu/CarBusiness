package com.example.carbusiness.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthenticationRequest(
    val username: String,
    val password: String
)