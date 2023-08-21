package com.example.photogallery.data.authorization.signup

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.user.data.UserDataResponse
import com.example.photogallery.domain.repository.SignUpRepository
import com.example.photogallery.domain.usecase.SignUpUserUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class SignUpUserUseCaseImpl @Inject constructor(private val repository: SignUpRepository) : SignUpUserUseCase {

    override suspend fun invoke(login: String, password: String): Flow<CloudResponse<UserDataResponse>> = flow {
        emit(repository.signUp(login, password))
    }.onStart {
        emit(CloudResponse.Loading())
    }.catch {
        emit(CloudResponse.Error(it))
    }

}