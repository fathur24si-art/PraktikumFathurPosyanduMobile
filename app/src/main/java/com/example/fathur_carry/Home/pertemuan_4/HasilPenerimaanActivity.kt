package com.example.fathur_carry.Home.pertemuan_4

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivityHasilPenerimaanBinding

class HasilPenerimaanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHasilPenerimaanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilPenerimaanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pesanMasuk = intent.getStringExtra("PESAN_RAHASIA") ?: "Ups! Tidak ada data yang diterima."

        binding.tvHasilPesan.text = ""

        // Animasi pop-up pada teks sukses
        binding.tvSuccess.scaleX = 0f
        binding.tvSuccess.scaleY = 0f
        binding.tvSuccess.animate().scaleX(1f).scaleY(1f).setDuration(600).setInterpolator(OvershootInterpolator(1.5f)).start()

        Handler(Looper.getMainLooper()).postDelayed({
            efekNgetikRamah(pesanMasuk)
        }, 300)

        binding.btnTutup.setOnClickListener {
            finish()
        }
    }

    private fun efekNgetikRamah(teksAsli: String) {
        val handler = Handler(Looper.getMainLooper())
        var index = 0
        val delayAntarKarakter = 30L // Kecepatan ngetik sedang (ramah dibaca)

        val runnable = object : Runnable {
            override fun run() {
                if (index <= teksAsli.length) {
                    binding.tvHasilPesan.text = teksAsli.substring(0, index)
                    index++
                    handler.postDelayed(this, delayAntarKarakter)
                }
            }
        }
        handler.post(runnable)
    }
}