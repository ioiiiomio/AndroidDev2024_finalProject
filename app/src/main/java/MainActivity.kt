package com.example.android_finals.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.android_finals.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        // Get the NavController from the NavHostFragment
        val navController: NavController = navHostFragment.navController

        // Set up BottomNavigationView to work with NavController
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        NavigationUI.setupWithNavController(bottomNav, navController)
    }
}
