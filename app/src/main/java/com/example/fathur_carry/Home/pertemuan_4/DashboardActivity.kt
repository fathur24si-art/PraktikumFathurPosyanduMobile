package com.example.fathur_carry.Home.pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.R
import com.google.android.material.snackbar.Snackbar

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Mengambil data teks dari Dashboard untuk di passing
        val tvTitle = findViewById<TextView>(R.id.tvMainTitle)
        val tvDesc = findViewById<TextView>(R.id.tvMainDesc)

        val judulHalaman = tvTitle.text.toString()
        val deskripsiHalaman = tvDesc.text.toString()

        val btnRumus = findViewById<Button>(R.id.btnRumus)
        val btnCustom1 = findViewById<Button>(R.id.btnCustom1)
        val btnCustom2 = findViewById<Button>(R.id.btnCustom2)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Navigasi ke Halaman Rumus
        btnRumus.setOnClickListener {
            val intent = Intent(this, RumusActivity::class.java)
            intent.putExtra("EXTRA_TITLE", judulHalaman)
            intent.putExtra("EXTRA_DESC", deskripsiHalaman)
            startActivity(intent)
        }

        // Navigasi ke Halaman Custom 1
        btnCustom1.setOnClickListener {
            val intent = Intent(this, CustomOneActivity::class.java)
            intent.putExtra("EXTRA_TITLE", judulHalaman)
            intent.putExtra("EXTRA_DESC", deskripsiHalaman)
            startActivity(intent)
        }

        // Navigasi ke Halaman Custom 2
        btnCustom2.setOnClickListener {
            val intent = Intent(this, CustomTwoActivity::class.java)
            intent.putExtra("EXTRA_TITLE", judulHalaman)
            intent.putExtra("EXTRA_DESC", deskripsiHalaman)
            startActivity(intent)
        }

        // Logika Logout dengan AlertDialog dan SnackBar
        btnLogout.setOnClickListener { view ->
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi Logout")
            builder.setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")

            // Jika memilih "Ya"
            builder.setPositiveButton("Ya") { dialog, _ ->
                // Asumsi ada LoginActivity di project Anda, ganti dengan class Login Anda
                // val intent = Intent(this, LoginActivity::class.java)
                // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                // startActivity(intent)
                // finish()
                dialog.dismiss()
            }

            // Jika memilih "Tidak"
            builder.setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
                Snackbar.make(view, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
            }

            val dialog = builder.create()
            dialog.show()
        }
    }
}