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
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                sessionManager.saveLoginSession(username)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Silakan isi username dan password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}