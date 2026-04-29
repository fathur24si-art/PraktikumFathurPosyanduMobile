package com.example.fathur_carry.Home.pertemuan_4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.R

class RumusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target_page)

        // Inisialisasi View
        val tvReceivedTitle = findViewById<TextView>(R.id.tvReceivedTitle)
        val tvReceivedDesc = findViewById<TextView>(R.id.tvReceivedDesc)

        // Menerima data dari Intent
        val titleFromDashboard = intent.getStringExtra("EXTRA_TITLE")
        val descFromDashboard = intent.getStringExtra("EXTRA_DESC")

        // Menampilkan data ke TextView
        tvReceivedTitle.text = titleFromDashboard ?: "Judul Tidak Ditemukan"
        tvReceivedDesc.text = descFromDashboard ?: "Deskripsi Tidak Ditemukan"
    }
}
