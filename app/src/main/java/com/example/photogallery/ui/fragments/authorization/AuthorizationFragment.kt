package com.example.photogallery.ui.fragments.authorization

import android.os.Bundle
import android.view.View
import com.example.photogallery.R
import com.example.photogallery.core.BaseFragment
import com.example.photogallery.databinding.FragmentAuthorizationBinding
import com.google.android.material.tabs.TabLayoutMediator

class AuthorizationFragment : BaseFragment<FragmentAuthorizationBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
    }

    private fun initViewPager() {
        binding.viewPager.adapter = AuthorizationAdapter(this@AuthorizationFragment)
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.setText(R.string.login)
                }

                1 -> {
                    tab.setText(R.string.registration)
                }
            }
        }.attach()
    }

}