package com.willy.tugas1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.willy.tugas1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefs = getSharedPreferences("user", Context.MODE_PRIVATE)
        val username = prefs.getString("username", "User")

        binding.tvWelcome.text = "Welcome, $username"

        binding.btnLogout.setOnClickListener {
            Toast.makeText(this, "Logout Berhasil !!!", Toast.LENGTH_SHORT).show()
//            // Optional: bersihkan data login
//            val prefs = getSharedPreferences("user", Context.MODE_PRIVATE)
//            prefs.edit().clear().apply()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
