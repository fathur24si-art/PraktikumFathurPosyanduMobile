package com.example.fathur_carry.pertemuan6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivityCatatanP6Binding

class CatatanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCatatanP6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatatanP6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}