package com.example.fathur_carry.Home.pertemuan_4

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivityBerandaUtamaBinding

class BerandaUtamaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBerandaUtamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerandaUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animasiKhasBelajar()

        binding.btnKeEksplorasi.setOnClickListener {
            val intent = Intent(this, EksplorasiMateriActivity::class.java)
            startActivity(intent)
        }
    }

    private fun animasiKhasBelajar() {
        // Animasi memantul pelan yang menyenangkan
        val bounceAnim = ObjectAnimator.ofPropertyValuesHolder(
            binding.btnKeEksplorasi,
            PropertyValuesHolder.ofFloat("scaleX", 1.05f),
            PropertyValuesHolder.ofFloat("scaleY", 1.05f)
        )
        bounceAnim.duration = 1000
        bounceAnim.repeatCount = ObjectAnimator.INFINITE
        bounceAnim.repeatMode = ObjectAnimator.REVERSE
        bounceAnim.interpolator = OvershootInterpolator()
        bounceAnim.start()
    }
}