package com.example.photogallery.domain.source

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.photos.fetch.data.PhotoData

interface FetchPhotosDataSource {

    suspend fun fetch(token: String, page: Int): CloudResponse<List<PhotoData>>

}