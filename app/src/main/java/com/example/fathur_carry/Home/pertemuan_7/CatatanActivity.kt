package com.example.fathur_carry.Home.pertemuan_7

import android.os.Bundle
import com.example.fathur_carry.BaseActivity
import com.example.fathur_carry.databinding.ActivityCatatanP6Binding

class CatatanActivity : BaseActivity() {

    private lateinit var binding: ActivityCatatanP6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatatanP6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupEdgeToEdge(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}