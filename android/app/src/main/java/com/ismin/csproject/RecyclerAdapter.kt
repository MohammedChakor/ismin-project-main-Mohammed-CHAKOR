package com.ismin.csproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray

class RecyclerAdapter(private var hommages: JSONArray) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemKode: TextView
        var itemKategori: TextView
        var itemIsi: TextView
        var tmstmp: TextView
        var adresse_pre: TextView

        init {
            itemKode = itemView.findViewById(R.id.kodePertanyaan)
            itemKategori = itemView.findViewById(R.id.kategori)
            itemIsi = itemView.findViewById(R.id.isiPertanyaan)
            tmstmp = itemView.findViewById(R.id.tmstmp)
            adresse_pre = itemView.findViewById(R.id.adresse_pre)

            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("adresse_pre", adresse_pre.text)
                    putExtra("adresse", itemKode.text)
                    putExtra("num", itemKategori.text)
                    putExtra("commemore", itemIsi.text)
                    putExtra("tmstmp", tmstmp.text)
                }
                context.startActivity(intent)
            }
    }}

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardview, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemKode.text = hommages.getJSONObject(i).getJSONObject("fields").getString("adresse_complete")
        viewHolder.itemKategori.text = hommages.getJSONObject(i).getJSONObject("fields").getString("identifiant")
        viewHolder.itemIsi.text = hommages.getJSONObject(i).getJSONObject("fields").getString("commemore")
        viewHolder.adresse_pre.text = hommages.getJSONObject(i).getJSONObject("fields").getString("precision_adresse")
        viewHolder.tmstmp.text = hommages.getJSONObject(i).getString("record_timestamp")


    }

    override fun getItemCount(): Int {
        return hommages.length()
    }}