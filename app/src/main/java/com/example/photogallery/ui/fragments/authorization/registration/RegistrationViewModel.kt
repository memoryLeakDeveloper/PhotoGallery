package com.example.photogallery.ui.fragments.authorization.registration

import androidx.lifecycle.ViewModel
import com.example.photogallery.data.prefs.PrefStore
import com.example.photogallery.data.user.cloud.UserData
import com.example.photogallery.domain.usecase.SignUpUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val prefStore: PrefStore, private val signupUserUseCase: SignUpUserUseCase) :
    ViewModel() {

    suspend fun register(login: String, password: String) = signupUserUseCase.invoke(login, password)

    fun saveUserData(userData: UserData?) {
        userData?.let {
            prefStore.token = userData.token ?: ""
            prefStore.userId = userData.userId ?: ""
            prefStore.login = userData.login ?: ""
        }
    }

}