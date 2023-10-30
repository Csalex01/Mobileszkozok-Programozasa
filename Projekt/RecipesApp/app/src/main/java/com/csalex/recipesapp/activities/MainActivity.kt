package com.csalex.recipesapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.csalex.recipesapp.R
import com.csalex.recipesapp.databinding.ActivityMainBinding
import com.csalex.recipesapp.ui.home.HomeFragment
import com.csalex.recipesapp.ui.profile.ProfileFragment
import com.csalex.recipesapp.ui.recipe.RecipesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var binding : ActivityMainBinding

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var navView: BottomNavigationView

//    private val fragmentManager: FragmentManager = supportFragmentManager
//    private val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate: MainActivity created")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.mainNavHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        navView = binding.bottomNavigationView

        navView.setupWithNavController(navController)

        binding.bottomNavigationView.setOnItemSelectedListener { item: MenuItem ->
            navController.navigate(R.id.action_homeFragment_to_recipesFragment)
            true
        }
    }

//    private fun switchFragment(item: MenuItem): Boolean {
//        var fragment: Fragment? = null
//
//        when(item.itemId) {
//            R.id.home -> {
//                fragment = HomeFragment()
//            }
//            R.id.recipes -> {
//                fragment = RecipesFragment()
//            }
//            R.id.profile -> {
//                fragment = ProfileFragment()
//            }
//        }
//
//        if(fragment == null)
//            return false

//        navController.navigate(item.itemId)

//        return true
//    }

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