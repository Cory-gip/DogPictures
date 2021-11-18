package com.caren.dogpictures

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.caren.dogpictures.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

private lateinit var navController: NavController

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)

       //findViewById<Button>(R.id.dogButton).setOnClickListener { viewModel.getNewDog() }


    }

    //private fun getDogURL() {}


}