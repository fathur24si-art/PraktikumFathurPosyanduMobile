package com.example.fathur_carry.Home.pertemuan_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivityDetailPertemuan4Binding

class DetailPertemuan4Activity : AppCompatActivity() {


    private lateinit var binding: ActivityDetailPertemuan4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityDetailPertemuan4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedMessage = intent.getStringExtra("EXTRA_MESSAGE")


        receivedMessage?.let {
            binding.tvReceivedData.text = it
        }
    }
}