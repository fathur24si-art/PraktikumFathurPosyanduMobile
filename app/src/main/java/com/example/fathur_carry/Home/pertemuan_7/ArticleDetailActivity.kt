package com.example.fathur_carry.Home.pertemuan_7

import android.os.Bundle
import com.example.fathur_carry.BaseActivity
import com.example.fathur_carry.databinding.ActivityArticleDetailP6Binding

class ArticleDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityArticleDetailP6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailP6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        // No setupEdgeToEdge here because it uses CollapsingToolbar with image

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}