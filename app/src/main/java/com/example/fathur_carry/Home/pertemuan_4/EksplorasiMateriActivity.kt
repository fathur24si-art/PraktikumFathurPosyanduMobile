package com.example.fathur_carry.Home.pertemuan_4

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivityEksplorasiMateriBinding

class EksplorasiMateriActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEksplorasiMateriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEksplorasiMateriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animasiMasukCeria()
        efekKartuMelayangHalus()

        binding.cardInteraktif.setOnClickListener {
            it.animate().scaleX(0.90f).scaleY(0.90f).setDuration(150).withEndAction {
                it.animate().scaleX(1f).scaleY(1f).setDuration(150).setInterpolator(OvershootInterpolator()).start()
                tampilkanDialogSistem()
            }.start()
        }

        binding.btnBalik.setOnClickListener {
            finish()
        }
    }

    private fun animasiMasukCeria() {
        binding.tvJudulMateri.alpha = 0f
        binding.tvJudulMateri.translationY = -50f
        binding.tvJudulMateri.animate().alpha(1f).translationY(0f).setDuration(500).start()

        binding.cardInteraktif.scaleX = 0f
        binding.cardInteraktif.scaleY = 0f
        binding.cardInteraktif.animate()
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(600)
            .setStartDelay(100)
            .setInterpolator(OvershootInterpolator(2f))
            .start()
    }

    private fun efekKartuMelayangHalus() {
        val floatAnim = ObjectAnimator.ofFloat(binding.cardInteraktif, "translationY", 0f, -8f, 0f)
        floatAnim.duration = 2000
        floatAnim.repeatCount = ObjectAnimator.INFINITE
        floatAnim.start()
    }

    private fun tampilkanDialogSistem() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Kirim Data?")
            .setMessage("Kamu siap mengirim data ke halaman berikutnya untuk menyelesaikan latihan ini?")
            .setPositiveButton("YA, KIRIM") { _, _ ->
                val intentData = Intent(this, HasilPenerimaanActivity::class.java).apply {
                    putExtra("PESAN_RAHASIA", "Kerja bagus, Fathur! 🎉\nKamu telah berhasil menyelesaikan misi LifeCycle & Intent hari ini. Teruslah belajar!")
                }
                startActivity(intentData)
            }
            .setNegativeButton("NANTI DULU", null)
            .create()

        dialog.show()
    }
}