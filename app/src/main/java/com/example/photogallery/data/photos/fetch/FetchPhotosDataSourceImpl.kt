package com.example.photogallery.data.photos.fetch

import com.example.photogallery.core.CloudResponse
import com.example.photogallery.data.photos.fetch.cloud.mapToData
import com.example.photogallery.data.photos.fetch.data.PhotoData
import com.example.photogallery.domain.source.FetchPhotosDataSource
import javax.inject.Inject

class FetchPhotosDataSourceImpl @Inject constructor(private val fetchPhotosService: FetchPhotosService) : FetchPhotosDataSource {

    override suspend fun fetch(token: String, page: Int): CloudResponse<List<PhotoData>> {
        val response = fetchPhotosService.getPhotosByPage(token, page)
        return if (response.isSuccessful) {
            response.body()?.let {
                CloudResponse.Success(it.map { it.mapToData() })
            } ?: run {
                CloudResponse.Error(Exception())
            }
        } else
            CloudResponse.Error(Exception(response.errorBody()?.string()))
    }
}