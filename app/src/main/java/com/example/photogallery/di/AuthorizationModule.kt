package com.example.photogallery.di

import com.example.photogallery.core.Api
import com.example.photogallery.data.authorization.login.LoginRepositoryImpl
import com.example.photogallery.data.authorization.login.LoginUserDataSourceImpl
import com.example.photogallery.data.authorization.login.LoginUserService
import com.example.photogallery.data.authorization.login.LoginUserUseCaseImpl
import com.example.photogallery.domain.repository.LoginRepository
import com.example.photogallery.domain.source.LoginUserDataSource
import com.example.photogallery.domain.usecase.LoginUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AuthorizationModule {

    @Provides
    fun provideLoginRepository(loginUserDataSource: LoginUserDataSource): LoginRepository =
        LoginRepositoryImpl(loginUserDataSource)

    @Provides
    fun provideLoginUserDataSource(api: Api): LoginUserDataSource = LoginUserDataSourceImpl(
        api.makeService(LoginUserService::class.java),
    )

    @Provides
    fun provideLoginUserUseCase(repository: LoginRepository): LoginUserUseCase = LoginUserUseCaseImpl(repository)

}