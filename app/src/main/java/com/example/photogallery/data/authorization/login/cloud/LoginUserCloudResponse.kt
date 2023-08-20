package com.example.photogallery.data.authorization.login.cloud

import com.example.photogallery.data.authorization.login.data.LoginUserDataResponse
import com.google.gson.annotations.SerializedName

data class LoginUserCloudResponse(
    @SerializedName("status") val status: Int?,
    @SerializedName("data") val data: UserCredentials?
)

data class UserCredentials(
    @SerializedName("userId") val userId: String?,
    @SerializedName("login") val login: String?,
    @SerializedName("token") val token: String?,
)

fun LoginUserCloudResponse.mapToData() = LoginUserDataResponse(this.status, this.data)