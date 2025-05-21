package com.willy.tugas1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.willy.tugas1.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val fullName = binding.etFullName.text.toString().trim()
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()

            when {
                fullName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() -> {
                    showToast("Semua field harus diisi")
                }
                password != confirmPassword -> {
                    showToast("Password dan Konfirmasi Password tidak cocok")
                }
                else -> {
                    showToast("Registrasi Berhasil! " + username)

                    val prefs = getSharedPreferences("user", Context.MODE_PRIVATE)
                    prefs.edit()
                        .putString("fullname", fullName)
                        .putString("username", username)
                        .putString("password", password)
                        .apply()

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()


                    binding.etFullName.text?.clear()
                    binding.etUsername.text?.clear()
                    binding.etPassword.text?.clear()
                    binding.etConfirmPassword.text?.clear()
                }
            }
        }
        binding.btnToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
