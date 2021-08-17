package com.example.carbusiness.data.service

import com.example.carbusiness.data.model.AuthenticationRequest
import com.example.carbusiness.utils.ApiConstants
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationService {

    @POST(ApiConstants.AuthenticationApi.authenticate)
    suspend fun authenticate(@Body authenticationRequest: AuthenticationRequest): String
}