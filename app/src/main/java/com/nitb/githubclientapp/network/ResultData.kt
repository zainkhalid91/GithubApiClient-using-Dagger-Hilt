package com.nitb.githubclientapp.network

sealed class ResultData<out T> {
    data class Success<out T>(val data: T? = null) : ResultData<T>()
    data class Loading(val nothing: Nothing? = null) : ResultData<Nothing>()
    data class Failure(val status: String? = null, val message: String? = null) :
        ResultData<Nothing>()

    data class Exception(val exception: kotlin.Exception? = null) : ResultData<Nothing>()
}