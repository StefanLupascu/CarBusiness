package com.example.carbusiness.ui.landing

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.carbusiness.LandingBinding
import com.example.carbusiness.R
import com.example.carbusiness.base.activity.CarBusinessActivity
import com.example.carbusiness.ui.login.LoginActivity

class LandingActivity : CarBusinessActivity<LandingBinding>(R.layout.activity_landing) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handler = Handler()
        val launchActivityTask = Runnable {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        handler.postDelayed(launchActivityTask, DELAY)
    }

    companion object {
        private const val DELAY = 3000L
    }
}