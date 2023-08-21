package com.example.photogallery.data.authorization.signup

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.user.data.UserDataResponse
import com.example.photogallery.domain.repository.SignUpRepository
import com.example.photogallery.domain.source.SignUpUserDataSource
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(private val signUpUserDataSource: SignUpUserDataSource) : SignUpRepository {


    override suspend fun signUp(login: String, password: String): CloudResponse<UserDataResponse> {
        return signUpUserDataSource.signUp(login, password)
    }
}