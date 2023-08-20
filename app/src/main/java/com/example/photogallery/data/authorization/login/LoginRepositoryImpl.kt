package com.example.photogallery.data.authorization.login

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.authorization.login.cloud.LoginUserCloudResponse
import com.example.photogallery.data.authorization.login.data.LoginUserDataResponse
import com.example.photogallery.domain.repository.LoginRepository
import com.example.photogallery.domain.source.LoginUserDataSource
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val loginUserDataSource: LoginUserDataSource) : LoginRepository {

    override suspend fun login(login: String, password: String): CloudResponse<LoginUserDataResponse> {
        return loginUserDataSource.login(login, password)
    }
}