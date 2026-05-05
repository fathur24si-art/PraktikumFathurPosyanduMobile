package com.example.fathur_carry.Home.pertemuan_7

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("posyandu_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val IS_LOGGED_IN = "isLoggedIn"
        private const val USERNAME = "username"
        private const val FULL_NAME = "full_name"
        private const val PHONE = "phone"
        private const val ADDRESS = "address"
    }

    fun saveLoginSession(username: String) {
        val editor = prefs.edit()
        editor.putBoolean(IS_LOGGED_IN, true)
        editor.putString(USERNAME, username)
        editor.apply()
    }

    fun saveProfile(fullName: String, phone: String, address: String) {
        val editor = prefs.edit()
        editor.putString(FULL_NAME, fullName)
        editor.putString(PHONE, phone)
        editor.putString(ADDRESS, address)
        editor.apply()
    }

    fun getProfile(): Map<String, String?> {
        return mapOf(
            "fullName" to prefs.getString(FULL_NAME, ""),
            "phone" to prefs.getString(PHONE, ""),
            "address" to prefs.getString(ADDRESS, "")
        )
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(IS_LOGGED_IN, false)
    }

    fun getUsername(): String? {
        return prefs.getString(USERNAME, "")
    }

    fun logout() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}