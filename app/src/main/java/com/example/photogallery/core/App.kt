package com.example.photogallery.core

import android.app.Application
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey("33ceeae3-3e2c-4ac4-a08d-f14e8fc1a478")
    }

    companion object {
        const val sharedPreferencesName = "sharedPreferencesName"
    }

}