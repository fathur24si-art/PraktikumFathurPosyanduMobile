package com.example.fathur_carry.pertemuan6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fathur_carry.R
import com.example.fathur_carry.databinding.FragmentHomeP6Binding
import java.util.Calendar


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

        // Sembunyikan Toolbar Activity agar tidak double header (karena fragment sudah punya header)
        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        // Setup UI
        setupGreeting()
        binding.tvUserName.text = getString(R.string.dev_name)


        setupMenuAction()
    }

    private fun setupGreeting() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)

        val greeting = when (hour) {
            in 0..11 -> "Selamat Pagi,"
            in 12..15 -> "Selamat Siang,"
            in 16..18 -> "Selamat Sore,"
            else -> "Selamat Malam,"
        }
        binding.tvGreeting.text = greeting
    }

    private fun setupMenuAction() {
        binding.btnMenuJadwal.setOnClickListener {
            showToast("Fitur Jadwal Posyandu segera hadir")
        }

        binding.btnMenuKMS.setOnClickListener {
            showToast("Membuka Digital KMS...")
        }

        binding.btnMenuEdukasi.setOnClickListener {
            showToast("Membuka Materi Edukasi...")
        }

        binding.btnMenuChat.setOnClickListener {
            showToast("Menghubungkan ke ChatBot...")
        }

        binding.ivProfile.setOnClickListener {
            showToast("Profil: ${getString(R.string.dev_name)}")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Tampilkan kembali ActionBar jika pindah ke fragment lain yang membutuhkannya
        (activity as? AppCompatActivity)?.supportActionBar?.show()
        _binding = null
    }
}
