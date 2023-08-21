package com.example.photogallery.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.photogallery.R
import com.example.photogallery.data.prefs.PrefStore
import com.example.photogallery.databinding.ActivityMainBinding
import com.example.photogallery.utils.bugger
import com.example.photogallery.utils.toGone
import com.example.photogallery.utils.toVisible
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var prefStore: PrefStore
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navigationView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        binding.fab.setOnClickListener { view ->
            navController.navigate(R.id.cameraFragment)
        }

        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_photos, R.id.nav_map), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val header = binding.navigationView.getHeaderView(0)
        supportActionBar?.title = ""
        navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar?.title = ""
            bugger(destination)
            when (destination.id) {
                R.id.authorizationFragment -> {
                    binding.fab.toGone()
                    binding.toolbar.toGone()
                }

                R.id.cameraFragment -> {
                    binding.fab.toGone()
                }

                else -> {
                    header.findViewById<TextView>(R.id.tv_user_id).text = prefStore.login
                    binding.fab.toVisible()
                    binding.toolbar.toVisible()
                }
            }
        }
        if (prefStore.token.isBlank())
            navController.navigate(R.id.authorizationFragment)

    }

    override fun onBackPressed() {
        if (binding.navigationView.isShown)
            binding.root.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}