package com.example.percobaan

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val gambarResId = intent.getIntExtra("gambarResId", 0)
        val judul = intent.getStringExtra("judul")
        val penulis = intent.getStringExtra("penulis")
        val harga = intent.getStringExtra("harga")
        val deskripsi = intent.getStringExtra("deskripsi")

        findViewById<ImageView>(R.id.imgDetail).setImageResource(gambarResId)
        findViewById<TextView>(R.id.tvJudulDetail).text = judul
        findViewById<TextView>(R.id.tvPenulisDetail).text = penulis
        findViewById<TextView>(R.id.tvHargaDetail).text = harga
        findViewById<TextView>(R.id.tvDeskripsiDetail).text = deskripsi
    }
}
