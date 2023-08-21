package com.example.photogallery.data.photos.upload

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.domain.repository.PhotosRepository
import com.example.photogallery.domain.usecase.UploadPhotoUseCase
import javax.inject.Inject

class UploadPhotoUseCaseImpl @Inject constructor(private val repository: PhotosRepository) : UploadPhotoUseCase {

    override suspend fun upload(token: String, photo: String, date: Double, lat: Long, lng: Long) =
        runCatching {
            repository.uploadPhoto(token, photo, date, lat, lng)
        }.getOrElse {
            CloudResponse.Error(it)
        }

}