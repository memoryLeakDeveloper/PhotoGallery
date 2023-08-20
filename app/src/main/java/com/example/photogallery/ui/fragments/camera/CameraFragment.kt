package com.example.photogallery.ui.fragments.camera

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.photogallery.core.BaseFragment
import com.example.photogallery.databinding.FragmentCameraBinding
import com.example.photogallery.ui.dialog.PermissionsDialog
import com.example.photogallery.utils.bugger
import com.google.android.gms.location.LocationServices
import java.util.Locale

class CameraFragment : BaseFragment<FragmentCameraBinding>() {

    private var imageCapture: ImageCapture? = null
    private val permissionsContract =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (permissions.entries.map { it.value }.contains(false)) {
                PermissionsDialog().showDialog(requireContext())
            } else {
                startCamera()
            }
        }
    private val closeDialogCallback: () -> Unit = {
        findNavController().navigateUp()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        startCamera()
    }

    override fun onStart() {
        super.onStart()
        permissionsContract.launch(
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager: LocationManager = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    @SuppressLint("MissingPermission", "SetTextI18n")
    private fun getLocation() {
        if (isLocationEnabled()) {
            LocationServices.getFusedLocationProviderClient(requireActivity()).lastLocation.addOnCompleteListener(requireActivity()) { task ->
                val location: Location? = task.result
                if (location != null) {
                    val geocoder = Geocoder(requireContext(), Locale.getDefault())
                    val list = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                    bugger(list)
                }
            }
        } else {
            startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build().also { it.setSurfaceProvider(binding.cameraSurface.surfaceProvider) }
            imageCapture = ImageCapture.Builder().build()
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }
}