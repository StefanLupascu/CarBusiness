package com.example.carbusiness.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.carbusiness.LoginBinding
import com.example.carbusiness.R
import com.example.carbusiness.base.activity.CarBusinessViewModelActivity
import com.example.carbusiness.ui.main.MainActivity
import com.example.carbusiness.utils.observeNonNull
import com.example.carbusiness.utils.showToast

class LoginActivity : CarBusinessViewModelActivity<LoginBinding, LoginViewModel, LoginViewModelFactory>(R.layout.activity_login, LoginViewModel::class) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            root.setOnClickListener {
                dismissKeyboard()
            }
            loginButton.setOnClickListener {
                startAuthentication()
            }
        }

        viewModel.event.observeNonNull(this) { event ->
            binding.progressBar.visibility = View.GONE
            when (event.consume()) {
                is LoginViewModel.Event.LoginSuccessful -> {
                    // TODO: Save session/token
                    goToMain()
                }
                else -> {
                    showToast(this, "Login Failed")
                }
            }
        }
    }

    private fun startAuthentication() {
        val username = binding.usernameField.text.toString()
        val password = binding.passwordField.text.toString()

        if (username == "" || password == "") {
            Log.e("STEFAN", "IT GOT HERE")
            Toast.makeText(this, "All fields must be completed", Toast.LENGTH_LONG).show()
            showToast(this, "All fields must be completed")
            return
        }

        binding.progressBar.visibility = View.VISIBLE
        viewModel.authenticate(username, password)
    }

    private fun goToMain() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }

    private fun dismissKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}