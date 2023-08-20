package com.example.photogallery.domain.source

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.authorization.login.data.LoginUserDataResponse

interface LoginUserDataSource {

    suspend fun login(login: String, password: String): CloudResponse<LoginUserDataResponse>

}