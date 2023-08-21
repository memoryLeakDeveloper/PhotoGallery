package com.example.photogallery.domain.repository

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.user.data.UserDataResponse

interface SignInRepository {

    suspend fun signIn(login: String, password: String): CloudResponse<UserDataResponse>
}