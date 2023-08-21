package com.example.photogallery.data.user.cloud

import com.google.gson.annotations.SerializedName

data class UserCloudRequest(
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String,
)