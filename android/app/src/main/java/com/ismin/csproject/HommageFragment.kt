package com.ismin.csproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject


class HommageFragment : Fragment() {

    private lateinit var hommages: JSONArray
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        apiCall()
        return inflater.inflate(R.layout.fragment_hommage, container, false)
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
                adapter = RecyclerAdapter(hommages)
                val rcvHommage = view?.findViewById<RecyclerView>(R.id.recycler_view)
                rcvHommage?.layoutManager = LinearLayoutManager(context)
                rcvHommage?.adapter = adapter
            },
            {
                Toast.makeText(activity, "It fails with error: $it", Toast.LENGTH_SHORT).show()
            }
        )

        requestQueue.add(stringRequest)
    }
}