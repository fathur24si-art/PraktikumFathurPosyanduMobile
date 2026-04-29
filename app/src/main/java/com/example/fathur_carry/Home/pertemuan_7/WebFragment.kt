package com.example.fathur_carry.Home.pertemuan_7

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.fathur_carry.databinding.FragmentWebP6Binding

class WebFragment : Fragment() {

    private var _binding: FragmentWebP6Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebP6Binding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.apply {
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: android.graphics.Bitmap?) {
                    _binding?.progressBar?.visibility = View.VISIBLE
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    _binding?.progressBar?.visibility = View.GONE
                }
            }
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            loadUrl("https://www.kemkes.go.id/id/home")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}