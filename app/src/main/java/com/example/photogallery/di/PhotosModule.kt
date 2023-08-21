package com.example.photogallery.di

import com.example.photogallery.core.Api
import com.example.photogallery.data.photos.PhotosRepositoryImpl
import com.example.photogallery.data.photos.fetch.FetchPhotosDataSourceImpl
import com.example.photogallery.data.photos.fetch.FetchPhotosService
import com.example.photogallery.data.photos.fetch.FetchPhotosUseCaseImpl
import com.example.photogallery.data.photos.upload.UploadPhotoDataSourceImpl
import com.example.photogallery.data.photos.upload.UploadPhotoService
import com.example.photogallery.data.photos.upload.UploadPhotoUseCaseImpl
import com.example.photogallery.domain.repository.PhotosRepository
import com.example.photogallery.domain.source.FetchPhotosDataSource
import com.example.photogallery.domain.source.UploadPhotoDataSource
import com.example.photogallery.domain.usecase.FetchPhotosUseCase
import com.example.photogallery.domain.usecase.UploadPhotoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class PhotosModule {

    @Provides
    fun provideFetchPhotosUserUseCase(repository: PhotosRepository): FetchPhotosUseCase = FetchPhotosUseCaseImpl(repository)

    @Provides
    fun provideFetchPhotosDataSource(api: Api): FetchPhotosDataSource = FetchPhotosDataSourceImpl(
        api.makeService(FetchPhotosService::class.java),
    )

    @Provides
    fun provideUploadPhotoUseCase(repository: PhotosRepository): UploadPhotoUseCase = UploadPhotoUseCaseImpl(repository)

    @Provides
    fun provideUploadPhotoDataSource(api: Api): UploadPhotoDataSource = UploadPhotoDataSourceImpl(
        api.makeService(UploadPhotoService::class.java),
    )

    @Provides
    fun providePhotosRepository(photosDataSource: FetchPhotosDataSource, uploadPhotoDataSource: UploadPhotoDataSource): PhotosRepository =
        PhotosRepositoryImpl(photosDataSource, uploadPhotoDataSource)
}