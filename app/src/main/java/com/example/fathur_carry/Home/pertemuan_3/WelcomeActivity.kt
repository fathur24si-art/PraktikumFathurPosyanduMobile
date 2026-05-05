package com.example.fathur_carry.Home.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.R
import com.example.fathur_carry.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- ANIMASI ---
        val entranceAnim = AnimationUtils.loadAnimation(this, R.anim.game_entrance)
        val bounceAnim = AnimationUtils.loadAnimation(this, R.anim.logo_bounce)

        // Terapkan animasi
        binding.ivWelcomeLogo.startAnimation(bounceAnim)
        binding.tvWelcomeTitle.startAnimation(entranceAnim)
        binding.tvWelcomeDesc.startAnimation(entranceAnim)
        binding.btnLogout.startAnimation(entranceAnim)

        // Ambil data username yang dikirim dari LoginActivity
        val username = intent.getStringExtra("USERNAME_DATA")

        // Set teks dengan custom font otomatis teraplikasi dari XML
        if (username != null) {
            binding.tvWelcomeDesc.text = "Selamat datang $username! Kamu telah berhasil masuk ke dalam sistem."
        }

        // Event saat tombol logout di klik
        binding.btnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            // Transisi slide saat logout
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            finish()
        }
    }
}