package com.example.photogallery.data.authorization.signin

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.user.cloud.UserCloudRequest
import com.example.photogallery.data.user.cloud.mapToData
import com.example.photogallery.data.user.data.UserDataResponse
import com.example.photogallery.domain.source.SignInUserDataSource
import javax.inject.Inject

class SignInUserDataSourceImpl @Inject constructor(private val signInUserService: SignInUserService) : SignInUserDataSource {

    override suspend fun signIn(login: String, password: String): CloudResponse<UserDataResponse> {
        val response = signInUserService.login(UserCloudRequest(login, password))
        return if (response.isSuccessful) {
            //todo null check
            CloudResponse.Success(response.body()!!.mapToData())
        } else
            CloudResponse.Error(Exception(response.errorBody()?.string()))
    }
}