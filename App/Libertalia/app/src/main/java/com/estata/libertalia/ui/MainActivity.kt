package com.estata.libertalia.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.estata.libertalia.R
import com.estata.libertalia.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        //1 segundo de espera para que se vea el splashscreen
        Thread.sleep(1000)

        //Regresa al tema principal
        setTheme(R.style.Theme_Libertalia)

        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).also { binding = it }.root)
        setSupportActionBar(binding.toolbar)

        val menulateralLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.catalogoFragment,
            R.id.historialFragment,
            R.id.estadoFragment,
            R.id.contactoFragment,
            ),
            menulateralLayout
        )

        NavigationUI.setupWithNavController(navView, navController)
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration)

    }
}