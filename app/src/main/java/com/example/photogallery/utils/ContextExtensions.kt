package com.example.photogallery.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityCompat

fun Context.checkAndVerifyFineLocationPermissions(requestPermissionLauncher: ActivityResultLauncher<String>): Boolean {
    val permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
    if (permission != PackageManager.PERMISSION_GRANTED) {
        // We don't have permission so prompt the user
        requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        return false
    }
    return true
}

fun Context.checkAndVerifyCoarseLocationPermissions(requestPermissionLauncher: ActivityResultLauncher<String>): Boolean {
    val permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
    if (permission != PackageManager.PERMISSION_GRANTED) {
        // We don't have permission so prompt the user
        requestPermissionLauncher.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
        return false
    }
    return true
}

fun Activity.checkAndVerifyCameraPermissions(requestPermissionLauncher: ActivityResultLauncher<String>): Boolean {
    val permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
    if (permission != PackageManager.PERMISSION_GRANTED) {
        // We don't have permission so prompt the user
        requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        return false
    }
    return true
}