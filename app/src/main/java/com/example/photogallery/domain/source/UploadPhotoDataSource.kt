package com.example.photogallery.domain.source

import com.example.photogallery.core.CloudResponse

interface UploadPhotoDataSource {

    suspend fun upload(token: String, photo: String, date: Double, lat: Long, lng: Long): CloudResponse<Unit>

}