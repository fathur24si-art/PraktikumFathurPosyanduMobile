package com.example.fathur_carry.pertemuan6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivityLoginP6Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginP6Binding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginP6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Dummy login logic
                sessionManager.saveLoginSession(username)
                
                // Alert Sukses Login yang Profesional
                MaterialAlertDialogBuilder(this)
                    .setTitle("Login Berhasil")
                    .setMessage("Selamat datang kembali, $username! Klik OK untuk masuk ke beranda.")
                    .setPositiveButton("OK") { _, _ ->
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    .setCancelable(false) // User wajib klik OK
                    .show()

            } else {
                // Alert Gagal Login
                MaterialAlertDialogBuilder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Username atau Password tidak boleh kosong. Silakan periksa kembali.")
                    .setPositiveButton("Coba Lagi", null)
                    .show()
            }
        }
    }
}