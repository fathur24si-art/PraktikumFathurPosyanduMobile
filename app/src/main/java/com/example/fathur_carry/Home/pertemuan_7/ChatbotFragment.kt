package com.example.fathur_carry.Home.pertemuan_7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fathur_carry.R
import com.example.fathur_carry.databinding.FragmentChatbotP6Binding
import com.google.android.material.card.MaterialCardView
import android.widget.LinearLayout
import android.view.Gravity

class ChatbotFragment : Fragment() {

    private var _binding: FragmentChatbotP6Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatbotP6Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSendChat.setOnClickListener {
            val message = binding.etChatMessage.text.toString()
            if (message.isNotEmpty()) {
                addUserMessage(message)
                binding.etChatMessage.setText("")
                
                // Simple bot response logic
                binding.root.postDelayed({
                    addBotResponse(message)
                }, 1000)
            }
        }
    }

    private fun addUserMessage(message: String) {
        val cardView = MaterialCardView(requireContext()).apply {
            radius = 24f
            cardElevation = 2f
            setCardBackgroundColor(resources.getColor(R.color.posyandu_primary))
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.END
                setMargins(0, 0, 0, 24)
            }
            layoutParams = params
        }

        val textView = TextView(requireContext()).apply {
            text = message
            setTextColor(resources.getColor(R.color.white))
            setPadding(32, 24, 32, 24)
            maxWidth = 600
        }

        cardView.addView(textView)
        binding.chatContainer.addView(cardView)
    }

    private fun addBotResponse(userMessage: String) {
        val response = when {
            userMessage.contains("jadwal", true) -> "Jadwal Posyandu terdekat adalah Senin depan jam 08.00 pagi, Bunda."
            userMessage.contains("vaksin", true) -> "Untuk vaksinasi, pastikan si kecil dalam kondisi sehat dan bawa Buku KIA ya."
            userMessage.contains("halo", true) || userMessage.contains("hi", true) -> "Halo Bunda! Ada yang bisa saya bantu hari ini?"
            else -> "Maaf Bunda, saya sedang belajar. Silakan hubungi petugas Posyandu untuk informasi lebih lanjut."
        }

        val cardView = MaterialCardView(requireContext()).apply {
            radius = 24f
            cardElevation = 2f
            setCardBackgroundColor(resources.getColor(R.color.white))
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.START
                setMargins(0, 0, 0, 24)
            }
            layoutParams = params
        }

        val textView = TextView(requireContext()).apply {
            text = response
            setTextColor(resources.getColor(R.color.posyandu_text_primary))
            setPadding(32, 24, 32, 24)
            maxWidth = 600
        }

        cardView.addView(textView)
        binding.chatContainer.addView(cardView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}