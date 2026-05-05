package com.example.fathur_carry.Home.pertemuan_4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.R

class CustomTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Pastikan Anda sudah membuat layout activity_custom_two.xml
        setContentView(R.layout.activity_custom_two)

        val tvReceivedTitle = findViewById<TextView>(R.id.tvReceivedTitle)
        val tvReceivedDesc = findViewById<TextView>(R.id.tvReceivedDesc)

        val titleFromDashboard = intent.getStringExtra("EXTRA_TITLE")
        val descFromDashboard = intent.getStringExtra("EXTRA_DESC")

        tvReceivedTitle.text = titleFromDashboard ?: "Judul Tidak Ditemukan"
        tvReceivedDesc.text = descFromDashboard ?: "Deskripsi Tidak Ditemukan"
    }
}