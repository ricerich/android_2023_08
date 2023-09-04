package com.example.ch13_101_googlemap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.ch13_101_googlemap.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    lateinit var videoMark: GroundOverlayOptions//추가
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)

//        setContentView(R.layout.activity_maps)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMapClickListener { point ->
            videoMark = GroundOverlayOptions().image(
                BitmapDescriptorFactory.fromResource(R.drawable.presence_video_busy))
                                       .position(point, 100f, 100f)
            mMap.addGroundOverlay(videoMark)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menu.add(0, 1, 0, "위성 지도")
        menu.add(0, 2, 0, "일반 지도")
        val sMenu = menu.addSubMenu("유명장소 바로가기 >>")
        sMenu.add(0, 3, 0, "정동진")
        sMenu.add(0, 4, 0, "해운대")
        sMenu.add(0, 5, 0, "땅끝마을")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
                return true
            }
            2 -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                return true
            }
            3 -> {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(
                    37.689254, 129.033051), 15f))
                return true
            }
            4 -> {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(
                    35.159003, 129.161882), 15f))
                return true
            }
            5 -> {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(
                    34.301472, 126.524048), 15f))
                return true
            }
        }
        return false
    }
}