package com.example.fathur_carry.Home.pertemuan_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivitySettingsP6Binding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsP6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsP6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}