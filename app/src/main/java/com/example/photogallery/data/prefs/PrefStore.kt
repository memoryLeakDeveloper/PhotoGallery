package com.example.photogallery.data.prefs

import android.content.SharedPreferences

class PrefStore(sharedPreferences: SharedPreferences) {

    var token by StringPreferenceDelegate(sharedPreferences, TOKEN_KEY, "")
    var userId by StringPreferenceDelegate(sharedPreferences, USER_ID_KEY, "ХЗ кто")

    companion object {
        private const val TOKEN_KEY = "TOKEN_KEY"
        private const val USER_ID_KEY = "USER_ID_KEY"
    }

}