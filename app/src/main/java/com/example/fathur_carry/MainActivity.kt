package com.example.fathur_carry

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fathur_carry.Home.HomeFragment
import com.example.fathur_carry.Home.pertemuan_7.AboutFragment
import com.example.fathur_carry.Home.pertemuan_7.ProfileFragment
import com.example.fathur_carry.Home.pertemuan_7.SessionManager
import com.example.fathur_carry.Message.MessageFragment
import com.example.fathur_carry.More.MoreFragment
import com.example.fathur_carry.databinding.ActivityHomeP7Binding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeP7Binding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeP7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)
        setupEdgeToEdge(binding.root)

        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_chatbot -> {
                    loadFragment(MessageFragment())
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.nav_about -> {
                    loadFragment(AboutFragment())
                    true
                }
                R.id.nav_logout -> {
                    logout()
                    true
                }
                else -> false
            }
        }
    }

    private fun logout() {
        sessionManager.logout()
        val intent = Intent(this, AuthActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}