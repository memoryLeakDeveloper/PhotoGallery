package com.example.photogallery.data.user.cloud

import com.example.photogallery.data.user.data.UserDataResponse
import com.google.gson.annotations.SerializedName

data class UserCloudResponse(
    @SerializedName("status") val status: Int?,
    @SerializedName("data") val data: UserData?
)

data class UserData(
    @SerializedName("userId") val userId: String?,
    @SerializedName("login") val login: String?,
    @SerializedName("token") val token: String?,
)

fun UserCloudResponse.mapToData() = UserDataResponse(this.status, this.data)