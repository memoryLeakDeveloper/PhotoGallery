package com.example.photogallery.data.prefs

import android.content.SharedPreferences

class PrefStore(sharedPreferences: SharedPreferences) {

    var token by StringPreferenceDelegate(sharedPreferences, TOKEN_KEY, "")
    var userId by StringPreferenceDelegate(sharedPreferences, USER_ID_KEY, "")
    var login by StringPreferenceDelegate(sharedPreferences, LOGIN_KEY, "")

    companion object {
        private const val TOKEN_KEY = "TOKEN_KEY"
        private const val USER_ID_KEY = "USER_ID_KEY"
        private const val LOGIN_KEY = "LOGIN_KEY"
    }

}