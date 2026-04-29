package com.example.fathur_carry.pertemuan6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.databinding.ActivityArticleDetailP6Binding

class ArticleDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleDetailP6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailP6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}