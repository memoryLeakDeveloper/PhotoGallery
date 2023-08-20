package com.example.photogallery.data.authorization.login

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.authorization.login.data.LoginUserDataResponse
import com.example.photogallery.domain.repository.LoginRepository
import com.example.photogallery.domain.usecase.LoginUserUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class LoginUserUseCaseImpl @Inject constructor(private val repository: LoginRepository) : LoginUserUseCase {

    override suspend fun invoke(login: String, password: String): Flow<CloudResponse<LoginUserDataResponse>> = flow {
        emit(repository.login(login, password))
    }.onStart {
        emit(CloudResponse.Loading())
    }.catch {
        emit(CloudResponse.Error(it))
    }

}