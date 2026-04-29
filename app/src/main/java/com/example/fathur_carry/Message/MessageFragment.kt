package com.example.fathur_carry.Message

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.fathur_carry.R
import com.example.fathur_carry.databinding.FragmentChatbotP6Binding
import com.google.android.material.card.MaterialCardView

class MessageFragment : Fragment() {
    private var _binding: FragmentChatbotP6Binding? = null
    private val binding get() = _binding!!

    // Perbaikan: Tambahkan '?' pada return type View agar sesuai dengan signature Fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatbotP6Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSendChat.setOnClickListener {
            val message = binding.etChatMessage.text.toString().trim()
            if (message.isNotEmpty()) {
                addUserMessage(message)
                binding.etChatMessage.setText("")

                // Mock Bot Response dengan pengecekan binding agar tidak crash jika fragment ditutup
                Handler(Looper.getMainLooper()).postDelayed({
                    if (_binding != null) {
                        addBotMessage("Terima kasih informasinya. Apakah ada lagi yang bisa saya bantu terkait $message?")
                    }
                }, 1000)
            }
        }
    }

    private fun addUserMessage(text: String) {
        val context = requireContext()
        val card = MaterialCardView(context).apply {
            radius = 24f
            cardElevation = 2f
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.posyandu_primary))

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(100, 0, 0, 24)
                gravity = Gravity.END
            }
            layoutParams = params
        }

        val tv = TextView(context).apply {
            this.text = text
            setTextColor(ContextCompat.getColor(context, R.color.white))
            setPadding(32, 24, 32, 24)
            // Menggunakan ResourcesCompat agar lebih aman untuk font custom
            typeface = ResourcesCompat.getFont(context, R.font.poppins_regular)
        }

        card.addView(tv)
        binding.chatContainer.addView(card)
        scrollToBottom()
    }

    private fun addBotMessage(text: String) {
        val context = requireContext()
        val card = MaterialCardView(context).apply {
            radius = 24f
            cardElevation = 2f
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.white))

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 0, 100, 24)
                gravity = Gravity.START
            }
            layoutParams = params
        }

        val tv = TextView(context).apply {
            this.text = text
            setTextColor(ContextCompat.getColor(context, R.color.posyandu_text_primary))
            setPadding(32, 24, 32, 24)
            typeface = ResourcesCompat.getFont(context, R.font.poppins_regular)
        }

        card.addView(tv)
        binding.chatContainer.addView(card)
        scrollToBottom()
    }

    private fun scrollToBottom() {
        // Otomatis scroll ke bawah saat ada pesan baru jika menggunakan ScrollView
        binding.root.post {
            if (_binding != null) {
                // Jika root layout Anda adalah ScrollView, gunakan ini:
                // binding.scrollView.fullScroll(View.FOCUS_DOWN)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}