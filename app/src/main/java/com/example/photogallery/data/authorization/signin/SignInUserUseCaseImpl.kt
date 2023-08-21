package com.example.photogallery.data.authorization.signin

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.user.data.UserDataResponse
import com.example.photogallery.domain.repository.SignInRepository
import com.example.photogallery.domain.usecase.SignInUserUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class SignInUserUseCaseImpl @Inject constructor(private val repository: SignInRepository) : SignInUserUseCase {

    override suspend fun invoke(login: String, password: String): Flow<CloudResponse<UserDataResponse>> = flow {
        emit(repository.signIn(login, password))
    }.onStart {
        emit(CloudResponse.Loading())
    }.catch {
        emit(CloudResponse.Error(it))
    }

}