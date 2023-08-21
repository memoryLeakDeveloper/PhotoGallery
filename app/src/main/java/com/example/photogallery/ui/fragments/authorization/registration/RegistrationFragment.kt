package com.example.photogallery.ui.fragments.authorization.registration

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.photogallery.R
import com.example.photogallery.core.BaseFragment
import com.example.photogallery.core.ExceptionHandler
import com.example.photogallery.core.getResult
import com.example.photogallery.databinding.FragmentRegistrationBinding
import com.example.photogallery.ui.dialog.LoadingDialog
import com.example.photogallery.utils.bugger
import com.example.photogallery.utils.hideKeyboard
import com.example.photogallery.utils.setOnSafeClickListener
import com.example.photogallery.utils.showToastShort
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {

    private val viewModel by viewModels<RegistrationViewModel>()
    private val loadingDialog = LoadingDialog()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() = binding.apply {
        btnLogin.setOnSafeClickListener {
            requireView().hideKeyboard()
            if (isFieldsAreEmpty()) {
                requireContext().showToastShort(R.string.empty_fields)
                return@setOnSafeClickListener
            }
            if (!isPasswordsAreTheSame()) {
                requireContext().showToastShort(R.string.passwords_mismatch)
                return@setOnSafeClickListener
            }
            loadingDialog.showDialog(requireContext())
            lifecycleScope.launch {
                viewModel.register(etLogin.text.toString(), etPassword.text.toString()).collect {
                    it.getResult(success = {
                        bugger(it.result)
                        viewModel.saveUserData(it.result.userData)
                        loadingDialog.hideDialog()
                        requireActivity().findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.nav_photos)
                    }, failure = {
                        bugger(it.exception)
                        requireContext().showToastShort(ExceptionHandler.recognizeReason(it.exception))
                        loadingDialog.hideDialog()
                    }, loading = {}
                    )
                }
            }

        }
    }

    private fun isFieldsAreEmpty() =
        (binding.etLogin.text.isNullOrBlank() || binding.etPassword.text.isNullOrBlank() || binding.etConfirmPassword.text.isNullOrBlank())

    private fun isPasswordsAreTheSame() = binding.etPassword.text.toString() == binding.etConfirmPassword.text.toString()

    override fun onStop() {
        super.onStop()
        loadingDialog.hideDialog()
    }
}