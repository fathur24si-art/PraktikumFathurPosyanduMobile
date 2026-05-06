package com.example.fathur_carry.Home.pertemuan_7

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fathur_carry.databinding.FragmentPosyanduInfoBinding

class PosyanduInfoFragment : Fragment() {

    private var _binding: FragmentPosyanduInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPosyanduInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReadMore.setOnClickListener {
            val url = "https://ayosehat.kemkes.go.id/posyandu-semakin-siap-melayani-masyarakat-secara-menyuluh-"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}