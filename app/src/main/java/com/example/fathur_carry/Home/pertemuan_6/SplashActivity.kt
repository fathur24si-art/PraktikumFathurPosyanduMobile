package com.example.fathur_carry.Home.pertemuan_6

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.fathur_carry.R
import com.example.fathur_carry.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Hide system UI for immersive feel
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        val scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up_bounce)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)


        binding.cvLogo.startAnimation(scaleUp)
        
        binding.tvAppName.visibility = View.INVISIBLE
        binding.tvTagline.visibility = View.INVISIBLE
        binding.splashProgress.visibility = View.INVISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            binding.tvAppName.visibility = View.VISIBLE
            binding.tvAppName.startAnimation(fadeIn)
            
            binding.tvTagline.visibility = View.VISIBLE
            binding.tvTagline.startAnimation(fadeIn)
            
            binding.splashProgress.visibility = View.VISIBLE
            binding.splashProgress.startAnimation(fadeIn)
        }, 800)

        // 4. Navigation Logic
        val sessionManager = SessionManager(this)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = if (sessionManager.isLoggedIn()) {
                Intent(this, HomeActivity::class.java)
            } else {
                Intent(this, LoginActivity::class.java)
            }
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 3500)
    }
}