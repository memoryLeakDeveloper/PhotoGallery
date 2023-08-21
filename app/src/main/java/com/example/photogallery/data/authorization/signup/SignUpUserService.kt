package com.example.photogallery.data.authorization.signup

import com.example.photogallery.core.Api
import com.example.photogallery.data.user.cloud.UserCloudRequest
import com.example.photogallery.data.user.cloud.UserCloudResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpUserService {
    @POST("${Api.apiVersion}/account/signup")
    suspend fun signup(@Body body: UserCloudRequest): Response<UserCloudResponse>
}