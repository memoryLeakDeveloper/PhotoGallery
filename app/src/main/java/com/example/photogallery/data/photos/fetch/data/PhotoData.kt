package com.example.photogallery.data.photos.fetch.data

data class PhotoData(
    val id: Int,
    val url: String,
    val date: Long,
    val lat: Int,
    val lng: Int,
)