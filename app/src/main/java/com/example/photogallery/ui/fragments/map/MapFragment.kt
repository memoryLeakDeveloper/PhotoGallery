package com.example.photogallery.ui.fragments.map

import android.os.Bundle
import android.view.View
import com.example.photogallery.R
import com.example.photogallery.core.BaseFragment
import com.example.photogallery.databinding.FragmentMapBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.runtime.image.ImageProvider

class MapFragment : BaseFragment<FragmentMapBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mapview.map.move(
            CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0F),
            null
        )
        val imageProvider = ImageProvider.fromResource(requireContext(), R.drawable.ic_pin1)
        binding.mapview.map.mapObjects.addPlacemark(Point(53.899217, 27.523030), imageProvider)

    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }

    override fun onStop() {
        super.onStop()
        MapKitFactory.getInstance().onStop()
        binding.mapview.onStop()
    }

}