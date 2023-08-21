package com.example.photogallery.domain.usecase

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.photos.fetch.data.PhotoData

interface FetchPhotosUseCase {

    suspend fun fetch(token: String, page: Int): CloudResponse<List<PhotoData>>

}