package com.example.photogallery.data.authorization.signin

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.user.data.UserDataResponse
import com.example.photogallery.domain.repository.SignInRepository
import com.example.photogallery.domain.source.SignInUserDataSource
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(private val signinUserDataSource: SignInUserDataSource) : SignInRepository {

    override suspend fun signIn(login: String, password: String): CloudResponse<UserDataResponse> {
        return signinUserDataSource.signIn(login, password)
    }
}