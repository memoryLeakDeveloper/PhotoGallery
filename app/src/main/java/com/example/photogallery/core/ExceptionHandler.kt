package com.example.photogallery.core

import com.example.photogallery.R
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ExceptionHandler {

    fun recognizeReason(error: Throwable?) = when (error) {
        is ConnectException, is UnknownHostException -> {
            R.string.check_internet_connection
        }

        is SocketTimeoutException -> {
            R.string.server_error
        }

        else -> {
            R.string.something_went_wrong
        }
    }
}