package com.example.photogallery.data.photos.fetch

import com.example.photogallery.core.Api
import com.example.photogallery.data.photos.fetch.cloud.PhotoCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface FetchPhotosService {
    @GET("${Api.apiVersion}/image")
    suspend fun getPhotosByPage(@Header("Roles") token: String, @Query("page") page: Int): Response<List<PhotoCloud>>
}