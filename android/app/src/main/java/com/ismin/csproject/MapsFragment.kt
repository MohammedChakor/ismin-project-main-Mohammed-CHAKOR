package com.ismin.csproject

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.json.JSONArray
import org.json.JSONObject

class MapsFragment : Fragment() {

    private lateinit var hommages: JSONArray;
    private var mMap: GoogleMap? = null


    private val callback = OnMapReadyCallback { googleMap ->
        mMap = googleMap
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        apiCall()
    }

    private fun apiCall() {
        val requestQueue = Volley.newRequestQueue(activity)
        val jsonobj = JSONObject()

        val stringRequest = JsonObjectRequest(
            Request.Method.GET,
            "https://opendata.paris.fr/api/records/1.0/search/?dataset=plaques_commemoratives_1939-1945&q=&rows=100&exclude.precision_adresse=NULL&exclude.datasetid=NULL&exclude.recordid=NULL&exclude.commemore=NULL&exclude.xy=NULL&exclude.adresse_complete=NULL",
            jsonobj,
            {
                hommages = it.getJSONArray("records")
                for(element in 0 until hommages.length()) {
                    if (hommages?.getJSONObject(element)?.getJSONObject("fields")?.has("xy") == true) {
                        val sydney = LatLng(hommages?.getJSONObject(element)?.getJSONObject("fields")?.getJSONArray("xy")!![0] as Double, hommages?.getJSONObject(element)?.getJSONObject("fields")?.getJSONArray("xy")!![1] as Double)
                        println(sydney)
                        mMap?.addMarker(MarkerOptions().position(sydney))
                        mMap?.moveCamera(CameraUpdateFactory.newLatLng(sydney))
                    }
                }
            },
            {
                Toast.makeText(activity, "It fails with error: $it", Toast.LENGTH_SHORT).show()
            }
        )

        requestQueue.add(stringRequest)
    }

}