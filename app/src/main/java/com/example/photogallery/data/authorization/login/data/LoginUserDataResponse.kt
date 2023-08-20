package com.example.photogallery.data.authorization.login.data

import com.example.photogallery.data.authorization.login.cloud.UserCredentials

data class LoginUserDataResponse(
    val status: Int?,
    val userCredentials: UserCredentials?
)