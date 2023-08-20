package com.example.photogallery.domain.usecase

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.authorization.login.cloud.LoginUserCloudResponse
import com.example.photogallery.data.authorization.login.data.LoginUserDataResponse
import kotlinx.coroutines.flow.Flow

interface LoginUserUseCase {

    suspend fun invoke(login: String, password: String): Flow<CloudResponse<LoginUserDataResponse>>

}