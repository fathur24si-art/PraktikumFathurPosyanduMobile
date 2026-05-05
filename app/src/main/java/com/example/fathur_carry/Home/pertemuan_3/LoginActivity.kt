package com.example.fathur_carry.Home.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.R
import com.example.fathur_carry.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- ANIMASI ---
        val entranceAnim = AnimationUtils.loadAnimation(this, R.anim.game_entrance)
        val bounceAnim = AnimationUtils.loadAnimation(this, R.anim.logo_bounce)

        // Terapkan efek melayang pada logo
        binding.ivLogo.startAnimation(bounceAnim)

        // Terapkan efek muncul (staggered) pada form
        binding.etUsername.startAnimation(entranceAnim)
        binding.etPassword.startAnimation(entranceAnim)
        binding.btnLogin.startAnimation(entranceAnim)


        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Validasi input
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Silakan isi Username dan Password terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("USERNAME_DATA", username)
                startActivity(intent)

                // Transisi pindah halaman yang halus
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish() // Mencegah user kembali ke login dengan tombol back
            }
        }
    }
}