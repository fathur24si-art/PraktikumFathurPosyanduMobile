package com.example.fathur_carry

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.fathur_carry.Home.pertemuan_7.SessionManager
import com.example.fathur_carry.databinding.ActivityLoginP6Binding

class AuthActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginP6Binding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginP6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)
        setupEdgeToEdge(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isEmpty()) {
                binding.tilUsername.error = getString(R.string.error_empty_field)
                return@setOnClickListener
            } else {
                binding.tilUsername.error = null
            }

            if (password.isEmpty()) {
                binding.tilPassword.error = getString(R.string.error_empty_field)
                return@setOnClickListener
            } else {
                binding.tilPassword.error = null
            }

            // Aturan Login:
            // 1. Username == Password (Aturan Praktikum)
            // 2. Username & Password sesuai dengan yang ada di SharedPreferences (Hasil Registrasi)
            if (username == password || sessionManager.checkLogin(username, password)) {
                sessionManager.saveLoginSession(username)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, getString(R.string.error_login_failed), Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}