package com.csalex.recipesapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.csalex.recipesapp.R
import com.csalex.recipesapp.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    companion object {
        const val TAG = "SplashActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Log.d(TAG, "onCreate: SplashActivity created")

        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            Log.d(TAG, "onCreate: Button clicked")

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user_input", binding.userInputEditText.text.toString())

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(MainActivity.TAG, "onStart: SplashActivity started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(MainActivity.TAG, "onResume: SplashActivity resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(MainActivity.TAG, "onPause: SplashActivity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(MainActivity.TAG, "onStop: SplashActivity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MainActivity.TAG, "onDestroy: SplashActivity destroyed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(MainActivity.TAG, "onRestart: SplashActivity restarted")
    }
}