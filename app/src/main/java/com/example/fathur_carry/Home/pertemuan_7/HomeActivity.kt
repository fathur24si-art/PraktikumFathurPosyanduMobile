package com.example.fathur_carry.Home.pertemuan_7

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import com.example.fathur_carry.R
import com.example.fathur_carry.databinding.ActivityHomeP7Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeP7Binding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Aktifkan Edge-to-Edge
        enableEdgeToEdge()

        binding = ActivityHomeP7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        // Handle Insets untuk Root dan Toolbar
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(left = systemBars.left, right = systemBars.right)
            binding.toolbar.updatePadding(top = systemBars.top)
            insets
        }

        // Handle Insets untuk Bottom Navigation
        ViewCompat.setOnApplyWindowInsetsListener(binding.bottomNavigation) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(bottom = systemBars.bottom)
            insets
        }

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
            // Menghindari reload fragment yang sama
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
            if (binding.bottomNavigation.selectedItemId == item.itemId && currentFragment != null) {
                return@setOnItemSelectedListener false
            }

            when (item.itemId) {
                R.id.nav_home -> {
                    binding.toolbar.title = "Home"
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_chatbot -> {
                    binding.toolbar.title = "Chatbot"
                    loadFragment(ChatbotFragment())
                    true
                }
                R.id.nav_profile -> {
                    binding.toolbar.title = "Profil Pengembang"
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.nav_logout -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Logout")
                        .setMessage("Apakah Anda yakin ingin keluar?")
                        .setPositiveButton("Ya") { _, _ ->
                            sessionManager.logout()
                            val intent = Intent(this, LoginActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                            finish()
                        }
                        .setNegativeButton("Tidak", null)
                        .show()
                    false
                }
                else -> false
            }
        }

        // Set default fragment
        if (savedInstanceState == null) {
            binding.toolbar.title = "Home"
            loadFragment(HomeFragment())
            binding.bottomNavigation.selectedItemId = R.id.nav_home
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
