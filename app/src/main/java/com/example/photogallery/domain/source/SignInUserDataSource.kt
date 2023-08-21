package com.example.photogallery.domain.source

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.user.data.UserDataResponse

interface SignInUserDataSource {

    suspend fun signIn(login: String, password: String): CloudResponse<UserDataResponse>

}