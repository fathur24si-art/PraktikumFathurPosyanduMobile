package com.example.fathur_carry.Home.pertemuan_6

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.fathur_carry.Home.pertemuan_7.AboutFragment
import com.example.fathur_carry.R
import com.example.fathur_carry.databinding.ActivityHomeP6Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeP6Binding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeP6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, 0)
            insets
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.toolbar) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top, 0, 0)
            insets
        }

        sessionManager = SessionManager(this)

        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        // Modern way to handle back press
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                MaterialAlertDialogBuilder(this@HomeActivity)
                    .setTitle("Keluar")
                    .setMessage("Tutup aplikasi Posyandu Digital?")
                    .setPositiveButton("Keluar") { _, _ ->
                        finish()
                    }
                    .setNegativeButton("Batal", null)
                    .show()
            }
        })

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            if (binding.bottomNavigation.selectedItemId == item.itemId) {
                return@setOnItemSelectedListener false
            }

            when (item.itemId) {
                R.id.nav_home -> {
                    binding.toolbar.title = "Home"
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_about -> {
                    binding.toolbar.title = "About Aplikasi"
                    loadFragment(AboutFragment())
                    true
                }
                R.id.nav_chatbot -> {
                    binding.toolbar.title = "Chatbot"
                    loadFragment(ChatbotFragment())
                    true
                }
                R.id.nav_profile -> {
                    binding.toolbar.title = "Profil"
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    fun navigateTo(itemId: Int) {
        binding.bottomNavigation.selectedItemId = itemId
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}