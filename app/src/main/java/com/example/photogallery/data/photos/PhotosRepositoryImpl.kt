package com.example.photogallery.data.photos

import com.example.photogallery.domain.repository.PhotosRepository
import com.example.photogallery.domain.source.FetchPhotosDataSource
import com.example.photogallery.domain.source.UploadPhotoDataSource
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val fetchPhotosDataSource: FetchPhotosDataSource,
    private val uploadPhotoDataSource: UploadPhotoDataSource
) : PhotosRepository {

    override suspend fun fetchPhotosByPage(token: String, page: Int) = fetchPhotosDataSource.fetch(token, page)

    override suspend fun uploadPhoto(token: String, photo: String, date: Double, lat: Long, lng: Long) =
        uploadPhotoDataSource.upload(token, photo, date, lat, lng)

}