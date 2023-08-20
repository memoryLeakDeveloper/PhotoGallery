package com.example.photogallery.di

import android.content.Context
import android.content.SharedPreferences
import com.example.photogallery.core.Api
import com.example.photogallery.core.App.Companion.sharedPreferencesName
import com.example.photogallery.data.prefs.PrefStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providePrefStore(sharedPreferences: SharedPreferences): PrefStore = PrefStore(sharedPreferences)

    @Provides
    @Singleton
    fun provideApi() = Api()
}