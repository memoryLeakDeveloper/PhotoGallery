package com.example.photogallery.data.photos.fetch

import com.example.photogallery.domain.repository.PhotosRepository
import com.example.photogallery.domain.usecase.FetchPhotosUseCase
import javax.inject.Inject

class FetchPhotosUseCaseImpl @Inject constructor(private val repository: PhotosRepository) : FetchPhotosUseCase {


    override suspend fun fetch(token: String, page: Int) = repository.fetchPhotosByPage(token, page)

}