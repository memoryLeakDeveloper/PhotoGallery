package com.example.photogallery.data.authorization.signup

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.user.cloud.UserCloudRequest
import com.example.photogallery.data.user.cloud.mapToData
import com.example.photogallery.data.user.data.UserDataResponse
import com.example.photogallery.domain.source.SignInUserDataSource
import com.example.photogallery.domain.source.SignUpUserDataSource
import javax.inject.Inject

class SignUpUserDataSourceImpl @Inject constructor(private val signUpUserService: SignUpUserService) : SignUpUserDataSource {

    override suspend fun signUp(login: String, password: String): CloudResponse<UserDataResponse> {
        val response = signUpUserService.signup(UserCloudRequest(login, password))
        return if (response.isSuccessful) {
            //todo null check
            CloudResponse.Success(response.body()!!.mapToData())
        } else
            CloudResponse.Error(Exception(response.errorBody()?.string()))
    }

}