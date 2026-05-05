package com.example.fathur_carry.Home.pertemuan_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fathur_carry.R
import com.example.fathur_carry.databinding.FragmentProfileP6Binding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileP6Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileP6Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Profile Data
        setupProfileInfo()

        // Handle Logout or other actions if necessary
        // In this fragment, we mostly show the developer profile as requested
    }

    private fun setupProfileInfo() {
        // Data is already set in XML via @string/dev_name etc.
        // But we can add interaction here
        binding.ivDevPhoto.setOnClickListener {
            Toast.makeText(context, "Profil Pengembang: Fathur Rahman", Toast.LENGTH_SHORT).show()
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
