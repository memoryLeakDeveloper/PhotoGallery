package com.example.photogallery.domain.usecase

import com.example.photogallery.core.CloudResponse

interface UploadPhotoUseCase {

    suspend fun upload(token: String, photo: String, date: Double, lat: Long, lng: Long): CloudResponse<Unit>

}