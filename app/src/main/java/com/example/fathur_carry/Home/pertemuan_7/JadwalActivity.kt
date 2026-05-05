package com.example.fathur_carry.Home.pertemuan_7

import android.os.Bundle
import com.example.fathur_carry.BaseActivity
import com.example.fathur_carry.databinding.ActivityJadwalP6Binding

class JadwalActivity : BaseActivity() {

    private lateinit var binding: ActivityJadwalP6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJadwalP6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupEdgeToEdge(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}