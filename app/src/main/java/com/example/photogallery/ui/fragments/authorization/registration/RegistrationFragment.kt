package com.example.photogallery.ui.fragments.authorization.registration

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.photogallery.core.BaseFragment
import com.example.photogallery.databinding.FragmentRegistrationBinding

class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {

    private val viewModel by viewModels<RegistrationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}