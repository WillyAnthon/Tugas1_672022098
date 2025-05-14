package com.willy.tugas1

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

                    binding.etFullName.text?.clear()
                    binding.etUsername.text?.clear()
                    binding.etPassword.text?.clear()
                    binding.etConfirmPassword.text?.clear()
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
