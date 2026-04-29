package com.example.fathur_carry.pertemuan6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivityVaksinP6Binding

class VaksinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVaksinP6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVaksinP6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}