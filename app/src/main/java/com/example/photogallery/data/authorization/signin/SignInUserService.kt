package com.example.photogallery.data.authorization.signin

import com.example.photogallery.core.Api
import com.example.photogallery.data.user.cloud.UserCloudRequest
import com.example.photogallery.data.user.cloud.UserCloudResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInUserService {
    @POST("${Api.apiVersion}/account/signin")
    suspend fun login(@Body emailBody: UserCloudRequest): Response<UserCloudResponse>
}