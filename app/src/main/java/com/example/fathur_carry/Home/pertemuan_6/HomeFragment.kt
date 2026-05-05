package com.example.fathur_carry.Home.pertemuan_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fathur_carry.R
import com.example.fathur_carry.databinding.FragmentHomeP6Binding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class HomeFragment : Fragment(), OnMapReadyCallback {

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

        val activity = requireActivity() as HomeActivity



        binding.menuRecord.setOnClickListener {
            val intent = android.content.Intent(requireContext(), CatatanActivity::class.java)
            startActivity(intent)
        }

        binding.menuSchedule.setOnClickListener {
            val intent = android.content.Intent(requireContext(), JadwalActivity::class.java)
            startActivity(intent)
        }

        binding.menuVaccine.setOnClickListener {
            val intent = android.content.Intent(requireContext(), VaksinActivity::class.java)
            startActivity(intent)
        }



        binding.cardArticle.setOnClickListener {
            val intent = android.content.Intent(requireContext(), ArticleDetailActivity::class.java)
            startActivity(intent)
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.home_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: com.google.android.gms.maps.GoogleMap) {
        val posyanduLocation = LatLng(-6.200000, 106.816666)
        googleMap.addMarker(MarkerOptions().position(posyanduLocation).title("Posyandu Melati Indah"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posyanduLocation, 15f))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}