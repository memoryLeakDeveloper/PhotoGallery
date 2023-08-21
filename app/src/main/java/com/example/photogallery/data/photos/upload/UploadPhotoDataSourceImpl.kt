package com.example.photogallery.data.photos.upload

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.photos.upload.cloud.UploadPhotoCloud
import com.example.photogallery.domain.source.UploadPhotoDataSource
import javax.inject.Inject

class UploadPhotoDataSourceImpl @Inject constructor(private val uploadPhotoService: UploadPhotoService) : UploadPhotoDataSource {

    override suspend fun upload(token: String, photo: String, date: Double, lat: Long, lng: Long): CloudResponse<Unit> {
        val response = uploadPhotoService.upload(token, UploadPhotoCloud(photo, date, lat, lng))
        return if (response.isSuccessful) {
            response.body()?.let {
                CloudResponse.Success(it)
            } ?: run {
                CloudResponse.Error(Exception())
            }
        } else
            CloudResponse.Error(Exception(response.errorBody()?.string()))
    }
}