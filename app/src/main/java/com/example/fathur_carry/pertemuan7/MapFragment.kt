package com.example.fathur_carry.pertemuan7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fathur_carry.R
import com.example.fathur_carry.databinding.FragmentMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val mapFragment = childFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: com.google.android.gms.maps.GoogleMap) {
        // Lokasi contoh: Posyandu di Jakarta
        val posyanduLocation = LatLng(-6.200000, 106.816666)
        googleMap.addMarker(MarkerOptions().position(posyanduLocation).title("Posyandu Melati Indah"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posyanduLocation, 15f))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}