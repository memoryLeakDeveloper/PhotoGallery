package com.example.photogallery.ui.fragments.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photogallery.data.photos.fetch.data.PhotoData
import com.example.photogallery.databinding.ItemPhotoBinding
import com.example.photogallery.utils.setPhoto
import com.example.photogallery.utils.toDmyString

class PhotosAdapter() : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    private var listPhotos = mutableListOf<PhotoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PhotoViewHolder(
        ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.binding.apply {
            val data = listPhotos[position]
            ivPhoto.setPhoto(data.url)
            tvDate.text = data.date.toDmyString()
        }
    }

    override fun getItemCount() = listPhotos.size

    class PhotoViewHolder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)

}