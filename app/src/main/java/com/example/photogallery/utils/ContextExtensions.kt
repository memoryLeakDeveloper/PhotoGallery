package com.example.photogallery.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToastShort(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

fun Context.showToastShort(@StringRes textRes: Int) = Toast.makeText(this, getString(textRes), Toast.LENGTH_SHORT).show()

fun Context.convertPxToDp(px: Float) = (px * resources.displayMetrics.density).toInt()
