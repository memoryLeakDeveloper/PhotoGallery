package com.example.photogallery.ui.fragments.authorization.login

import androidx.lifecycle.ViewModel
import com.example.photogallery.data.prefs.PrefStore
import com.example.photogallery.data.user.cloud.UserData
import com.example.photogallery.domain.usecase.SignInUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val prefStore: PrefStore, private val signinUserUseCase: SignInUserUseCase) : ViewModel() {

    suspend fun login(login: String, password: String) = signinUserUseCase.invoke(login, password)

    fun saveUserData(userData: UserData?) {
        userData?.let {
            prefStore.token = userData.token ?: ""
            prefStore.userId = userData.userId ?: ""
            prefStore.login = userData.login ?: ""
        }
    }
}