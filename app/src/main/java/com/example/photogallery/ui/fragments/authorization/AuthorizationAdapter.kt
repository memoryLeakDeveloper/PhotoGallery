package com.example.photogallery.ui.fragments.authorization

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.photogallery.ui.fragments.authorization.login.LoginFragment
import com.example.photogallery.ui.fragments.authorization.registration.RegistrationFragment

class AuthorizationAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LoginFragment()
            else -> RegistrationFragment()
        }
    }

    override fun getItemCount() = 2
}