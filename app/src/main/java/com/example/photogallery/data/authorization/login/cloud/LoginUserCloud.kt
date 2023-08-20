package com.example.photogallery.data.authorization.login.cloud

import com.google.gson.annotations.SerializedName

data class LoginUserCloud(
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String,
)