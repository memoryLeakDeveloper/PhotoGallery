package com.example.photogallery.data.photos.fetch.cloud

import com.example.photogallery.data.photos.fetch.data.PhotoData
import com.google.gson.annotations.SerializedName

data class PhotoCloud(
    @SerializedName("id") val id: Int,
    @SerializedName("url") val url: String,
    @SerializedName("date") val date: Long,
    @SerializedName("lat") val lat: Int,
    @SerializedName("lng") val lng: Int,
)

fun PhotoCloud.mapToData() = PhotoData(id, url, date, lat, lng)