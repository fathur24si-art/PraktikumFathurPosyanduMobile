package com.example.fathur_carry

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.widget.doOnTextChanged
import com.example.fathur_carry.Home.pertemuan_7.SessionManager
import com.example.fathur_carry.databinding.ActivityRegisterBinding
import java.util.*

class RegisterActivity : BaseActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)
        setupEdgeToEdge(binding.root)

        setupReligionDropdown()
        setupDatePicker()
        setupTextWatchers()

        binding.btnRegister.setOnClickListener {
            validateAndRegister()
        }

        binding.tvLogin.setOnClickListener {
            finish()
        }
    }

    private fun setupTextWatchers() {
        binding.etFullName.doOnTextChanged { _, _, _, _ -> binding.tilFullName.error = null }
        binding.etUsername.doOnTextChanged { _, _, _, _ -> binding.tilUsername.error = null }
        binding.etPassword.doOnTextChanged { _, _, _, _ -> binding.tilPassword.error = null }
        binding.etConfirmPassword.doOnTextChanged { _, _, _, _ -> binding.tilConfirmPassword.error = null }
        binding.actReligion.doOnTextChanged { _, _, _, _ -> binding.tilReligion.error = null }
        
        binding.rgGender.setOnCheckedChangeListener { _, _ ->
            binding.tvGenderError.visibility = View.GONE
        }
    }

    private fun setupReligionDropdown() {
        val religions = arrayOf("Islam", "Kristen Protestan", "Katolik", "Hindu", "Buddha", "Khonghucu")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, religions)
        binding.actReligion.setAdapter(adapter)
    }

    private fun setupDatePicker() {
        val calendar = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year"
            binding.etBirthDate.setText(date)
            binding.tilBirthDate.error = null
        }

        binding.etBirthDate.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun validateAndRegister() {
        val fullName = binding.etFullName.text.toString().trim()
        val birthDate = binding.etBirthDate.text.toString().trim()
        val gender = when (binding.rgGender.checkedRadioButtonId) {
            R.id.rbMale -> getString(R.string.male)
            R.id.rbFemale -> getString(R.string.female)
            else -> ""
        }
        val religion = binding.actReligion.text.toString().trim()
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val confirmPassword = binding.etConfirmPassword.text.toString().trim()

        var isValid = true

        // Validation for each field
        if (fullName.isEmpty()) {
            binding.tilFullName.error = getString(R.string.error_empty_field)
            isValid = false
        }

        if (birthDate.isEmpty()) {
            binding.tilBirthDate.error = getString(R.string.error_empty_field)
            isValid = false
        }

        if (gender.isEmpty()) {
            binding.tvGenderError.visibility = View.VISIBLE
            binding.tvGenderError.text = getString(R.string.error_select_gender)
            isValid = false
        }

        if (religion.isEmpty()) {
            binding.tilReligion.error = getString(R.string.error_empty_field)
            isValid = false
        }

        if (username.isEmpty()) {
            binding.tilUsername.error = getString(R.string.error_empty_field)
            isValid = false
        }

        if (password.isEmpty()) {
            binding.tilPassword.error = getString(R.string.error_empty_field)
            isValid = false
        }

        if (confirmPassword.isEmpty()) {
            binding.tilConfirmPassword.error = getString(R.string.error_empty_field)
            isValid = false
        } else if (password != confirmPassword) {
            binding.tilConfirmPassword.error = getString(R.string.error_password_mismatch)
            isValid = false
        }

        if (isValid) {
            // Save to SharedPreferences via SessionManager
            sessionManager.saveRegistration(
                fullName = fullName,
                birthDate = birthDate,
                gender = gender,
                religion = religion,
                username = username,
                password = password
            )
            
            // Navigate back to Login or show success (Finishing here as requested implicitly)
            finish()
        }
    }
}