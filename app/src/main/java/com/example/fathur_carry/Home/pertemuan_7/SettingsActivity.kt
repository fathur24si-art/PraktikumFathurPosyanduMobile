package com.example.fathur_carry.Home.pertemuan_7

import android.os.Bundle
import com.example.fathur_carry.BaseActivity
import com.example.fathur_carry.databinding.ActivitySettingsP6Binding

class SettingsActivity : BaseActivity() {

    private lateinit var binding: ActivitySettingsP6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsP6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupEdgeToEdge(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}