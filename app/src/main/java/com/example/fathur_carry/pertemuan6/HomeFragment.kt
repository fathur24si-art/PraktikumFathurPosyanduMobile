package com.example.fathur_carry.pertemuan6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fathur_carry.databinding.FragmentHomeP6Binding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeP6Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeP6Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val sessionManager = SessionManager(requireContext())
        val username = sessionManager.getUsername()
        binding.tvWelcome.text = "Halo, $username!"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}