package com.example.photogallery.domain.repository

import android.graphics.Bitmap
import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.photos.fetch.data.PhotoData

interface PhotosRepository {

    suspend fun fetchPhotosByPage(token: String, page: Int): CloudResponse<List<PhotoData>>

    suspend fun uploadPhoto(token: String, photo: String, date: Double, lat: Long, lng: Long): CloudResponse<Unit>
}