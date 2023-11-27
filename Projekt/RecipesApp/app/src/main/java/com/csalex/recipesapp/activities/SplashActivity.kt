package com.csalex.recipesapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import com.csalex.recipesapp.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    companion object {
        const val TAG = "SplashActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Log.d(TAG, "onCreate: SplashActivity created")

        // Create a timer thread that switches to the main thread after 3 seconds
        val handlerThread = HandlerThread("SplashHandlerThread", -10)
        handlerThread.start()

        val handler = Handler(handlerThread.looper)
        handler.postDelayed({

            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 3000)
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