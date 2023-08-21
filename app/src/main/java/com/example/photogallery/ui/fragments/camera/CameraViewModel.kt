package com.example.photogallery.ui.fragments.camera

import androidx.lifecycle.ViewModel
import com.example.photogallery.data.prefs.PrefStore
import com.example.photogallery.domain.usecase.UploadPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
    private val prefStore: PrefStore,
    private val uploadPhotoUseCase: UploadPhotoUseCase
) : ViewModel() {

    suspend fun uploadPhoto(photo: String, date: Double, lat: Long, lng: Long) =
        uploadPhotoUseCase.upload(prefStore.token, photo, date, lat, lng)

}