package com.ismin.csproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private lateinit var commemore: String
    private lateinit var adresse: String
    private lateinit var adresse_precise: String
    private lateinit var tmstmp: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        this.commemore = intent.getSerializableExtra("commemore") as String
        this.adresse = intent.getSerializableExtra("adresse") as String
        this.adresse_precise = intent.getSerializableExtra("adresse_pre") as String
        this.tmstmp = intent.getSerializableExtra("tmstmp") as String
        val comView1 = findViewById<TextView>(R.id.f_detail_txt_commemore)
        val comView2 = findViewById<TextView>(R.id.f_detail_txt_adresse)
        val comView3 = findViewById<TextView>(R.id.f_detail_txt_tmstmp)
        comView1.text = this.commemore
        comView2.text = this.adresse.plus("\n").plus(this.adresse_precise)
        comView3.text = this.tmstmp


    }
}