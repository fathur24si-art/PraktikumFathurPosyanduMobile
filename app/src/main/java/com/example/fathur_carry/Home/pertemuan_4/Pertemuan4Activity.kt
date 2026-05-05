package com.example.fathur_carry.Home.pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivityPertemuan4Binding

class Pertemuan4Activity : AppCompatActivity() {

    // Deklarasi View Binding
    private lateinit var binding: ActivityPertemuan4Binding

    companion object {
        private const val TAG = "LifeCycleActivityCheck"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityPertemuan4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: Activity Dibuat")

        // Memanggil ID dari XML sekarang tinggal pakai "binding."
        binding.cardIntentDialog.setOnClickListener {
            tampilkanDialog()
        }
    }

    private fun tampilkanDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Konfirmasi Aksi")
        builder.setMessage("Kirim data 'Fathur Carry' ke halaman selanjutnya?")

        builder.setPositiveButton("Ya, Kirim") { _, _ ->
            val intent = Intent(this, DetailPertemuan4Activity::class.java).apply {
                putExtra("EXTRA_MESSAGE", "Halo! Ini adalah data intent dari Pertemuan 4.")
            }
            startActivity(intent)
        }

        builder.setNegativeButton("Batal") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Activity Mulai Terlihat")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Activity Siap Berinteraksi")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Activity Sebagian Tertutup")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Activity Tidak Terlihat Sepenuhnya")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Activity Dihancurkan")
    }
}