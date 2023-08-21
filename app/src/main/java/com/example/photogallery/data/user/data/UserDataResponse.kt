package com.example.photogallery.data.user.data

import com.example.photogallery.data.user.cloud.UserData

data class UserDataResponse(
    val status: Int?,
    val userData: UserData?
)