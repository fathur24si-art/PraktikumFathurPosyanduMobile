package com.example.fathur_carry.Home.pertemuan_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fathur_carry.databinding.FragmentProfileP6Binding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileP6Binding? = null
    private val binding get() = _binding!!
    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileP6Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sessionManager = SessionManager(requireContext())

        // Load existing profile data
        val profile = sessionManager.getProfile()
        binding.etFullName.setText(profile["fullName"])
        binding.etPhone.setText(profile["phone"])
        binding.etAddress.setText(profile["address"])
        
        binding.tvProfileUsername.text = "@${sessionManager.getUsername()}"
        binding.tvProfileName.text = if (profile["fullName"].isNullOrEmpty()) "Bunda Posyandu" else profile["fullName"]

        binding.btnSaveProfile.setOnClickListener {
            val name = binding.etFullName.text.toString()
            val phone = binding.etPhone.text.toString()
            val address = binding.etAddress.text.toString()

            if (name.isNotEmpty()) {
                sessionManager.saveProfile(name, phone, address)
                binding.tvProfileName.text = name
                Toast.makeText(requireContext(), "Profil berhasil diperbarui", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSettings.setOnClickListener {
            val intent = android.content.Intent(requireContext(), SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}