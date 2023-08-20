package com.example.photogallery.data.authorization.login

import com.example.photogallery.core.Api
import com.example.photogallery.data.authorization.login.cloud.LoginUserCloud
import com.example.photogallery.data.authorization.login.cloud.LoginUserCloudResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginUserService {
    @POST("${Api.apiVersion}/account/signin")
    suspend fun login(@Body emailBody: LoginUserCloud): Response<LoginUserCloudResponse>
}