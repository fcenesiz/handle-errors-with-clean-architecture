package com.fcenesiz.handleerrors.util

sealed class Resource<T>(val data: T? = null, val message: UiText? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: UiText? = null, data: T?= null) : Resource<T>(data, message)
}