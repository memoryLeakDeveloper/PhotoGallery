package com.example.photogallery.data.authorization.login

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.authorization.login.cloud.LoginUserCloud
import com.example.photogallery.data.authorization.login.cloud.LoginUserCloudResponse
import com.example.photogallery.data.authorization.login.cloud.mapToData
import com.example.photogallery.data.authorization.login.data.LoginUserDataResponse
import com.example.photogallery.domain.source.LoginUserDataSource
import javax.inject.Inject

class LoginUserDataSourceImpl @Inject constructor(private val loginUserService: LoginUserService) : LoginUserDataSource {

    override suspend fun login(login: String, password: String): CloudResponse<LoginUserDataResponse> {
        val response = loginUserService.login(LoginUserCloud(login, password))
        return if (response.isSuccessful) {
            //todo null check
            CloudResponse.Success(response.body()!!.mapToData())
        } else
            CloudResponse.Error(Exception(response.errorBody()?.string()))
    }
}