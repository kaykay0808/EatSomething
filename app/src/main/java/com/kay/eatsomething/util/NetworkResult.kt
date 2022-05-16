package com.kay.eatsomething.util

// This class will handle the responses from our Api

sealed class NetworkResult<T>(
    // two parameters that will represent the actual data from our Api and the other one which will represent a message.
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : NetworkResult<T>(data)
    class Error<T>(message: String?, data: T? = null) : NetworkResult<T>(data, message)
    class Loading<T> : NetworkResult<T>()
}
