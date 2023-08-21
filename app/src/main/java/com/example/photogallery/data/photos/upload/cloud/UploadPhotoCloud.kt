package com.example.photogallery.data.photos.upload.cloud

import com.google.gson.annotations.SerializedName

data class UploadPhotoCloud(
    @SerializedName("base64Image") val image: String,
    @SerializedName("date") val date: Double,
    @SerializedName("lat") val lat: Long,
    @SerializedName("lng") val lng: Long,
)