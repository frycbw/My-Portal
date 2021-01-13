package com.example.portaltech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnNav = findViewById<BottomNavigationView>(R.id.nav)
        val navControl = findNavController(R.id.fragment3)

        btnNav.setupWithNavController(navControl)
    }
}