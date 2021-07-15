package com.example.carbusiness.ui.landing

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import com.example.carbusiness.LandingBinding
import com.example.carbusiness.R
import com.example.carbusiness.base.CarBusinessActivity
import com.example.carbusiness.ui.main.MainActivity

class LandingActivity : CarBusinessActivity<LandingBinding>(R.layout.activity_landing) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding.textView.text = "Car Business Landing"

        val handler = Handler()
        val launchActivityTask = Runnable {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        handler.postDelayed(launchActivityTask, DELAY)
    }

    companion object {
        private const val DELAY = 3000L
    }
}