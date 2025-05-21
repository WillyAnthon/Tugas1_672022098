package com.willy.tugas1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.willy.tugas1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefs = getSharedPreferences("user", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val usernameInput = binding.etLoginUsername.text.toString()
            val passwordInput = binding.etLoginPassword.text.toString()

            val savedUsername = prefs.getString("username", null)
            val savedPassword = prefs.getString("password", null)

            if (usernameInput == savedUsername && passwordInput == savedPassword) {
                if (usernameInput == savedUsername && passwordInput == savedPassword) {
                    Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            } else {
                Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}
