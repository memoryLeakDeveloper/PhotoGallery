package com.example.photogallery.data.photos.upload

import com.example.photogallery.core.Api
import com.example.photogallery.data.photos.upload.cloud.UploadPhotoCloud
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface UploadPhotoService {
    @POST("${Api.apiVersion}/image")
    suspend fun upload(@Header("Roles") token: String, @Body data: UploadPhotoCloud): Response<Unit>
}