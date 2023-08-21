package com.example.photogallery.domain.usecase

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.user.data.UserDataResponse
import kotlinx.coroutines.flow.Flow

interface SignInUserUseCase {

    suspend fun invoke(login: String, password: String): Flow<CloudResponse<UserDataResponse>>

}