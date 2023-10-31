package com.csalex.recipesapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.csalex.recipesapp.R
import com.csalex.recipesapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate: MainActivity created")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {

            val navController: NavController = findNavController(R.id.mainNavHostFragment)

            when(it.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.homeFragment)
                    return@OnItemSelectedListener true
                }
                R.id.recipes -> {
                    navController.navigate(R.id.recipesFragment)
                    return@OnItemSelectedListener true
                }
                R.id.profile -> {
                    navController.navigate(R.id.profileFragment)
                    return@OnItemSelectedListener true
                }
                else -> return@OnItemSelectedListener true
            }

        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: MainActivity started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: MainActivity resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: MainActivity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: MainActivity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: MainActivity destroyed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: MainActivity restarted")
    }
}