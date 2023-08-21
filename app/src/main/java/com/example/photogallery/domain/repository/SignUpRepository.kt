package com.example.photogallery.domain.repository

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.user.data.UserDataResponse

interface SignUpRepository {

    suspend fun signUp(login: String, password: String): CloudResponse<UserDataResponse>
}