package com.example.photogallery.di

import com.example.photogallery.core.Api
import com.example.photogallery.data.authorization.signin.SignInRepositoryImpl
import com.example.photogallery.data.authorization.signin.SignInUserDataSourceImpl
import com.example.photogallery.data.authorization.signin.SignInUserService
import com.example.photogallery.data.authorization.signin.SignInUserUseCaseImpl
import com.example.photogallery.data.authorization.signup.SignUpRepositoryImpl
import com.example.photogallery.data.authorization.signup.SignUpUserDataSourceImpl
import com.example.photogallery.data.authorization.signup.SignUpUserService
import com.example.photogallery.data.authorization.signup.SignUpUserUseCaseImpl
import com.example.photogallery.domain.repository.SignInRepository
import com.example.photogallery.domain.repository.SignUpRepository
import com.example.photogallery.domain.source.SignInUserDataSource
import com.example.photogallery.domain.source.SignUpUserDataSource
import com.example.photogallery.domain.usecase.SignInUserUseCase
import com.example.photogallery.domain.usecase.SignUpUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AuthorizationModule {

    @Provides
    fun provideSignInRepository(signinUserDataSource: SignInUserDataSource): SignInRepository =
        SignInRepositoryImpl(signinUserDataSource)

    @Provides
    fun provideSignInUserDataSource(api: Api): SignInUserDataSource = SignInUserDataSourceImpl(
        api.makeService(SignInUserService::class.java),
    )

    @Provides
    fun provideSignInUserUseCase(repository: SignInRepository): SignInUserUseCase = SignInUserUseCaseImpl(repository)

    @Provides
    fun provideSignUpRepository(signupUserDataSource: SignUpUserDataSource): SignUpRepository =
        SignUpRepositoryImpl(signupUserDataSource)

    @Provides
    fun provideSignUpUserDataSource(api: Api): SignUpUserDataSource = SignUpUserDataSourceImpl(
        api.makeService(SignUpUserService::class.java),
    )

    @Provides
    fun provideSignUpUserUseCase(repository: SignUpRepository): SignUpUserUseCase = SignUpUserUseCaseImpl(repository)

}