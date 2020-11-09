package com.inoid.submission.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.inoid.submission.HomeActivity
import com.inoid.submission.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                val intent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }, 1000)
        }
    }
}