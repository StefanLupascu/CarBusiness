package com.example.carbusiness.utils

import android.util.Log
import retrofit2.HttpException

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class NetworkError<out T>(val exception: HttpException) : Result<T>()
    object UnknownError : Result<Nothing>()
}

suspend fun <T> wrapIntoResult(function: suspend () -> T): Result<T> = try {
    Result.Success(function())
} catch (exception: HttpException) {
    Result.NetworkError(exception)
} catch (exception: Exception) {
    Result.UnknownError
}