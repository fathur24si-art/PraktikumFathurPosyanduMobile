package com.example.fathur_carry.Home.pertemuan_7

import android.os.Bundle
import com.example.fathur_carry.BaseActivity
import com.example.fathur_carry.databinding.ActivityVaksinP6Binding

class VaksinActivity : BaseActivity() {

    private lateinit var binding: ActivityVaksinP6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVaksinP6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupEdgeToEdge(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}