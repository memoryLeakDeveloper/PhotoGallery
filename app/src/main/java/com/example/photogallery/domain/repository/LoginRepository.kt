package com.example.photogallery.domain.repository

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.authorization.login.data.LoginUserDataResponse

interface LoginRepository {

    suspend fun login(login: String, password: String): CloudResponse<LoginUserDataResponse>
}