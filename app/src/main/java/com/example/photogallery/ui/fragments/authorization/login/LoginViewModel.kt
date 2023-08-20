package com.example.photogallery.ui.fragments.authorization.login

import androidx.lifecycle.ViewModel
import com.example.photogallery.domain.usecase.LoginUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUserUseCase: LoginUserUseCase) : ViewModel() {

    suspend fun login(login: String, password: String) = loginUserUseCase.invoke(login, password)
}