package com.example.photogallery.ui.fragments.authorization.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.photogallery.R
import com.example.photogallery.core.BaseFragment
import com.example.photogallery.core.getResult
import com.example.photogallery.databinding.FragmentLoginBinding
import com.example.photogallery.ui.dialog.LoadingDialog
import com.example.photogallery.utils.bugger
import com.example.photogallery.utils.setOnSafeClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel: LoginViewModel by viewModels()
    private val loadingDialog = LoadingDialog()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() = binding.apply {
        btnLogin.setOnSafeClickListener {
            loadingDialog.showDialog(requireContext())
            lifecycleScope.launch {
                viewModel.login(etLogin.text.toString(), etPassword.text.toString()).collect {
                    it.getResult(success = {
                        bugger(it.result)
                        loadingDialog.hideDialog()
                        requireActivity().findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.nav_photos)
                    }, failure = {
                        bugger(it.exception)
                        loadingDialog.hideDialog()
                    }, loading = {}
                    )
                }
            }

        }
    }

    override fun onStop() {
        super.onStop()
        loadingDialog.hideDialog()
    }
}