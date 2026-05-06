package com.example.fathur_carry.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fathur_carry.Home.pertemuan_7.CatatanActivity
import com.example.fathur_carry.Home.pertemuan_7.JadwalActivity
import com.example.fathur_carry.Home.pertemuan_7.VaksinActivity
import com.example.fathur_carry.Home.pertemuan_7.ArticleDetailActivity
import com.example.fathur_carry.Home.pertemuan_7.PosyanduInfoFragment
import com.example.fathur_carry.Home.pertemuan_7.SessionManager
import com.example.fathur_carry.R
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
        
        binding.menuRecord.setOnClickListener {
            startActivity(Intent(requireContext(), CatatanActivity::class.java))
        }

        binding.menuSchedule.setOnClickListener {
            startActivity(Intent(requireContext(), JadwalActivity::class.java))
        }

        binding.menuVaccine.setOnClickListener {
            startActivity(Intent(requireContext(), VaksinActivity::class.java))
        }

        binding.menuInfo.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PosyanduInfoFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.cardArticle.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PosyanduInfoFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}